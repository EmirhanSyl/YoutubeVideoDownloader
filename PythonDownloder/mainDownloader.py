import sys
import argparse
import json

from pytube import YouTube
from pytube.exceptions import VideoUnavailable
import pytube
import warnings

parser = argparse.ArgumentParser()

parser.add_argument('--videourl', help='Youtube Video url to be downloaded')
parser.add_argument('--location', help='Location to write the Youtube video file')
parser.add_argument('--download', action='store_true', help='Enable Video&Audio Download')
parser.add_argument('--itag', type=int, default=-1, help='Stream ID to spesify the quality or type of video. If empty, the highest resolution video will be downloaded')

args, _ = parser.parse_known_args()

videourl = args.videourl
location = args.location
download = args.download
itag = args.itag


pytube.innertube._default_clients['ANDROID']=pytube.innertube._default_clients['WEB']

yt = None
try:
    yt = YouTube(videourl)
except VideoUnavailable:
    warnings.warn("Invalid YouTube video link!")
    raise RuntimeError("Invalid YouTube video link!") from None

print("Title: ",yt.title)
print("Number of views: ",yt.views)
print("Length of video: ",yt.length,"seconds")
print("Description: ",yt.description)
print("Ratings: ",yt.rating)

with open('videoInfo.txt', 'w') as file:
    file.write("Thumbnail: " + yt.thumbnail_url)
    file.write("\nTitle: " + yt.title)
    file.write("\nLength: " + str(yt.length))

for stream in yt.streams.filter(only_audio=True):
    print(stream)

for stream in yt.streams.filter(only_video=True):
    print(stream)

for stream in yt.streams.filter(progressive=True):
    print(stream)


only_audio_Streamings = list(yt.streams.filter(only_audio=True))
only_video_Streamings = list(yt.streams.filter(only_video=True))
progressive_Streamings = list(yt.streams.filter(progressive=True))

# Extract necessary attributes for each stream
only_audio_data = []
for stream in only_audio_Streamings:
    only_audio_data.append({
        'url': stream.url,
        'itag': stream.itag,
        'mime_type': stream.mime_type,
        # 'resolution': stream.resolution,
        'abr': stream.fps if hasattr(stream, 'fps') else stream.abr,
        # 'vcodec&acodec': stream.vcodec if hasattr(stream, 'vcodec') else None,
    })

only_video_data = []
for stream in only_video_Streamings:
    only_video_data.append({
        'url': stream.url,
        'itag': stream.itag,
        'mime_type': stream.mime_type,
        'resolution': stream.resolution,
        'fps': stream.fps,
        # 'vcodec': stream.vcodec,
    })

progressive_data = []
for stream in progressive_Streamings:
    progressive_data.append({
        'url': stream.url,
        'itag': stream.itag,
        'mime_type': stream.mime_type,
        'resolution': stream.resolution,
        'fps': stream.fps,
        # 'vcodec': stream.vcodec,
    })

# Create a dictionary with the extracted data
data = {
    'only_audio_Streamings': only_audio_data,
    'only_video_Streamings': only_video_data,
    'progressive_Streamings': progressive_data
}

json_data = json.dumps(data, indent=4)

with open('data.json', 'w') as file:
    file.write(json_data)


save_location = "C:/users/emirs/Desktop/"
if location is not None:
    save_location = location

ys = None
if itag == -1:
    ys = yt.streams.get_highest_resolution
else:
    ys = yt.streams.get_by_itag(itag)

if download:
    ys.download(save_location)