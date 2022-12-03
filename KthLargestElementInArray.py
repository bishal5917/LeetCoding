def KthLargestElementInArray(nums, k):
    nums.sort()
    nums.reverse()
    return nums[k-1]


if __name__ == "__main__":
    nums = [3, 2, 1, 5, 6, 4]
    k = 2
    print(KthLargestElementInArray(nums, k))
