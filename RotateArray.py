# This isn't the optimal solution
# def RotateArray(nums, k):
#     for _ in range(k):
#         last = nums[-1]
#         for i in range(0, len(nums)):
#             nums[len(nums) - 1 - i] = nums[len(nums) - 2 - i]
#         nums[0] = last

#     return nums


def RotateArray(nums, k):
    temp = [0 for _ in nums]

    for i in range(0, len(nums)):
        pos = (i + k) % len(nums)
        temp[pos] = nums[i]

    for i in range(0, len(nums)):
        nums[i] = temp[i]


if __name__ == "__main__":
    nums = [1, 2, 3, 4, 5]
    k = 2
    print(RotateArray(nums, k))
