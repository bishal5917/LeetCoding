def removeDuplicates(nums):

    currnum = nums[0]
    i = 1
    while i < len(nums):
        if currnum == nums[i]:
            while currnum == nums[i]:
                nums.remove(currnum)
                nums.append("_")
        if nums[i] != "_":
            if currnum < nums[i]:
                currnum = nums[i]
        i += 1

    count = 0
    for item in nums:
        if item != "_":
            count += 1

    return count, nums


if __name__ == "__main__":
    nums = [1, 1, 1, 1, 1]
    nums = [0, 0, 0, 0, 0]
    print(removeDuplicates(nums))
