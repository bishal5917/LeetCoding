def HouseRobber(nums):
    moneySumsA = 0
    moneySumsB = 0

    i = 0
    while i < len(nums):
        moneySumsA += nums[i]
        i += 2

    i = 1
    while i < len(nums):
        moneySumsB += nums[i]
        i += 2

    return max(moneySumsA, moneySumsB)


if __name__ == "__main__":
    nums = [2, 7, 9, 3, 1]
    nums = [1, 1, 1]
    nums = [1, 2]
    nums = [2, 1, 1, 2]
    print(HouseRobber(nums))
