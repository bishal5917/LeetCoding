import time
def Pattern():
    for i in range(0,6):
        for j in range(i):
            print(".",end="")
            time.sleep(0.1)
        print("\n")
Pattern()
