import argparse
from moviepy.editor import VideoFileClip, AudioFileClip

parser = argparse.ArgumentParser()

parser.add_argument('--videoPath', help='Video file path')
parser.add_argument('--audioPath', help='Audio file path')
parser.add_argument('--outputPath', help='Audio file path')

args, _ = parser.parse_known_args()

videoPath = args.videoPath
audioPath = args.audioPath
outputPath = args.outputPath

if outputPath is None:
    outputPath = ""


def merge_audio_with_video(video_path, audio_path, output_path):
    video = VideoFileClip(video_path)
    audio = AudioFileClip(audio_path)

    video = video.set_audio(audio)
    video.write_videofile(output_path, codec='libx264')


merge_audio_with_video(videoPath, audioPath, outputPath)
