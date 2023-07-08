import os

# Absolute path of the output file
output_file = os.path.join(os.path.dirname(__file__), 'test.txt')

with open(output_file, 'w') as file:
    file.write("Thumbnail: ")
    file.write("\nTitle: ")
    file.write("\nLength: ")
    print("Content Written!")
    file.flush()