# time is O(log(n)) and space is O(1) if we perform by iteration
# because in iteration, we wont save any values , we just traverse or visit them
import time

def binarySearchFunc(list,toFind,left,right):
    while (left<right):
        mid=(left+right)//2
        ifmatch=list[mid]
        if toFind==ifmatch:
            return mid
        elif toFind<ifmatch:
            right=mid-1
        else:
            left=mid+1

if __name__=="__main__":
    list=[1,2,45,67,87,105,107]
    initial=time.time()
    x=binarySearchFunc(list,105,0,len(list)-1)
    print(f"It took {time.time()-initial} seconds")
    print(x)

