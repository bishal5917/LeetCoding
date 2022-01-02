def staircase():
    n=7
    for i in range(n):
        for j in range(n):
            if (i+j>=n):
                print("*",end=" ")
            else:
                print(" ",end=" ")
        print("\n")
            
           
staircase()