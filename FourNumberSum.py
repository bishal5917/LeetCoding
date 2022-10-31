#Time complexity = O(n^2)
#Space complexity = O(n^2)
#Using the naive 4 for loops approach we could have solved this using O(n^4) complexity

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
    # print(hash)
    return quadruplets

def FourNumberSum(arr,target):
    quadruplets=[]
    for i in range(0,len(arr)):
        for j in range(i,len(arr)):
            for k in range(j,len(arr)):
                for l in range(k,len(arr)):
    
                

    return quadruplets

if __name__=="__main__":
    arr=[7,6,4,-1,1,2]
    target=16
    print(FourNumberSum(arr,target))