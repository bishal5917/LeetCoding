n=5

for i in range(n):
    for j in range(n):
        if (i>=1 and i<=n-2) and (j>=1 and j<=n-2):
            print(" ",end=" ")
        else:
            print("*",end=" ")
    print("\n")