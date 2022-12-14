# time is O(log(n)) and space is O(log(n)) if we perform by recursion
# because in recursion data is stored in recursion stack during recursion calls

import time

def binarySearchFunc(list,toFind,left,right):
    if left>right:
        return 0
    mid = (left+right)//2
    ifmatch=list[mid]
    if toFind==ifmatch:
        return mid
    elif toFind<ifmatch:
        return binarySearchFunc(list,toFind,left,mid-1)
    else:
        return binarySearchFunc(list,toFind,mid+1,right)

if __name__=="__main__":
    list=[1,2,45,67,87,105,107,108,109,110,200,300,400,800,1000,1010]
    first=time.time()
    x=binarySearchFunc(list,1010,0,len(list)-1)
    print(f"It took {time.time()-first} time")
    print(x)
  

