
def containsDuplicate(nums):
    nums.sort()
    
    for i in range(0,len(nums)-1):
        if nums[i]==nums[i+1]:
            return True

    return False


if __name__=="__main__":
    nums = [1,2,3,1]
    nums = [1,2,3,4]
    nums = [1,1,1,3,3,4,3,2,4,2]


    print(containsDuplicate(nums))