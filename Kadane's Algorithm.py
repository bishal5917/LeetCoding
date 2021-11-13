
def kadanesAlgo():
    array=[3,5,-9,1,3,-2,3,4,7,2,-9,6,3,1,-5,4]
    maxSoFar=array[0]
    maxEnding=array[0]
    for i in range(0,len(array)):
        nums=array[i]
        maxEnding=max(nums,maxEnding+nums)
        maxSoFar=max(maxSoFar,maxEnding)
    return maxSoFar

x=kadanesAlgo()
print("max is",x)