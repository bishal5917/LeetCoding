
a=[[10,4,2],
    [2,1,3],
    [4,1,0]]

b=[[2,0],
   [3,1],
   [3,0]]

c=[[0,0],
   [0,0],
   [0,0]]

if(len(a[0]) is not len(b)):
    print("sorry, i cant multiply")

else:
    for i in range(0,len(c)):
        for j in range(0,len(c[0])):
            for k in range(0,len(b)):
                c[i][j] += a[i][k]*a[k][j]

    for row in c:
        print(row)
                    