n=9

for i in range(n):
    for j in range(n):
        if (i-j<=0):
            print("*",end=" ")
        else:
            print(" ",end=" ")
    print("\n")