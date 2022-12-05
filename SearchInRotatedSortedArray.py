def SearchInRotatedSortedArray(nums, target):
    left = 0
    right = len(nums) - 1

    while left <= right:
        mid = (left + right) // 2
        if nums[left] > target and nums[right] < target:
            left = mid + 1
        if nums[left] < target and nums[right] > target:
            right = mid - 1
        if nums[mid] == target:
            return mid

    return -1


if __name__ == "__main__":
    nums = [4, 5, 6, 7, 0, 1, 2]
    target = 2
    print(SearchInRotatedSortedArray(nums, target))
