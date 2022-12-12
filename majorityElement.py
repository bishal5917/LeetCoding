
def majorityElement(nums):
    hash={}
    for item in nums:
        if item not in hash:
            hash[item]=1
        else:
            hash[item]+=1

    # return hash
    n=len(nums)
    for item in hash:
        if hash[item]>(n//2):
            return item


if __name__=="__main__":
    nums = [2,2,1,1,1,2,2]
    print(majorityElement(nums))

