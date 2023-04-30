import whisper
import sys
# https://github.com/openai/whisper 
#where podcasts are located
#/Users/alexmarz/library/Group Containers/243LU875E5.groups.com.apple.podcasts/library/cache
import whisper

model = whisper.load_model("tiny")
result = model.transcribe("Social.mp3")

print(result["text"], file=open("Social.txt", "w"))