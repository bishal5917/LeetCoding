def FindDuplicateNumber(nums):
    hash = {}
    for item in nums:
        if item not in hash:
            hash[item] = 1
        else:
            return item


if __name__ == "__main__":
    nums = [1, 3, 4, 2, 2]
    print(FindDuplicateNumber(nums))
