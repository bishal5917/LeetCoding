numList=[]
for i in range(3):
    binNum=input("Enter the binary Number")
    numList.append(binNum)

for i in range( len(numList)):
    if numList[i]==0:
        numList[i]=1
    elif numList[i]==1:
        numList[i]=0
    else:
        print("Invalid Input Given")

for items in numList:
    print(items,end="")