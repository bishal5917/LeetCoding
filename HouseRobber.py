# An Awesome dynamic programming question from LeetCode
def HouseRobber(nums):
    if len(nums) <= 2:
        return max(nums)

    nums[0] = nums[0]
    nums[1] = max(nums[0], nums[1])
    for i in range(2, len(nums)):
        nums[i] = max(nums[i], nums[i] + nums[i - 2], nums[i - 1])

    return nums[-1]


if __name__ == "__main__":
    nums = [2, 1, 1, 2]
    print(HouseRobber(nums))
