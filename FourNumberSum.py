#Optimal Approach
#Time complexity = O(n^2)
#Space complexity = O(n^2)
def FourNumberSum(arr,target):
    hash={}
    quadruplets=[]
    for i in range(0,len(arr)):
        for j in range(i+1,len(arr)):
            diff=target-(arr[i]+arr[j])
            if diff in hash:
                #This for loop is used in that case if there are more than one matching pairs
                for x in range(0,len(hash[diff])):
                    quadruplets.append([hash[diff][x]+[arr[i],arr[j]]])
                
        for k in range(0,i):
            toadd=(arr[i]+arr[k])
            if toadd not in hash:
                hash[toadd]=[[arr[k],arr[i]]]
            else:
                hash[toadd].append([arr[k],arr[i]])

    return quadruplets

#Naive Approach
#Time complexity = O(n^4)
#Space complexity = O(n^4)
def FourNumberSumNaiveApproach(arr,target):
    sumNums=[]
    for i in range(0,len(arr)):
        for j in range(i,len(arr)):
            for k in range(j,len(arr)):
                for l in range(k,len(arr)):
                    if (arr[i]+arr[j]+arr[k]+arr[l])==target:
                        sumNums.append([arr[i],arr[j],arr[k],arr[l]])
    
    return sumNums

if __name__=="__main__":
    arr=[7,6,4,-1,1,2]
    target=16
    print(FourNumberSum(arr,target))
    print(FourNumberSumNaiveApproach(arr,target))
