
import pyttsx3
from datetime import datetime
import os
import time
from win10toast import ToastNotifier

engine = pyttsx3.init('dummy')
voices = engine.getProperty('voices')
engine.setProperty('voice', voices[0].id)


def speak(audio):
    engine.say(audio)
    engine.runAndWait()


def popup():
    toaster = ToastNotifier()
    toaster.show_toast("Dude , Its time for your online class ! Opening Teams Now .....")
    toaster.fadeout=15000


def reminder():
    obj_now = datetime.now()
    if obj_now.hour == 6 or obj_now.minute == 44:
        popup()
        speak("its time for your online class")
        t_path = "C:\\Users\\dell\\AppData\\Local\\Microsoft\\Teams\\current\\teams.exe"
        os.startfile(t_path)


if __name__ == "__main__":            
    reminder()
