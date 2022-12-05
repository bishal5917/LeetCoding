# O(log(n)) time complexity and O(1) space complexity
def PeakFinding(nums):
    # left = 0
    # right = len(arr) - 1
    # while left <= right:
    #     mid = (left + right) // 2
    #     if arr[mid] <= arr[mid + 1]:
    #         left = mid + 1
    #     else:
    #         right = mid

    # return arr[left]
    for i in range(0, len(nums) - 1):
        if nums[i] > nums[i - 1] and nums[i] > nums[i + 1]:
            return i


nums = [1, 2, 3, 1]
PeakFinding(nums)
