passlist = [1, 3, 12, 5, 6, 7, 8, 20]

n = int(input("enter your symbol number "))

for item in passlist:
    if item == n:
        print("Congratulations,You have passed the exam successfully !!! ")
        break


else:
    print("You failed,please try your best another time !")
