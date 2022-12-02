def RotateArray(nums, k):
    for _ in range(k):
        last = nums[-1]
        for i in range(0, len(nums)):
            nums[len(nums) - 1 - i] = nums[len(nums) - 2 - i]
        nums[0] = last

    return nums


if __name__ == "__main__":
    nums = [1, 2, 3, 4, 5, 6, 7]
    k = 3
    print(RotateArray(nums, k))
