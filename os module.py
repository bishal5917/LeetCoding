import os

print(os.listdir())
print(os.getcwd())
os.chdir("D:\PYTHON PRACTICES")
#print(os.mkdir("python directory"))
#os.rename("currencytable.txt","currtable.txt")
x=os.path.exists("D:\\ PYTHON PRACTICES")
print(x)
print(os.environ.get('pathh'))
print(os.path.isfile("D://srt"))



