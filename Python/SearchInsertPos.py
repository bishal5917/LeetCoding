def searchInsert(nums, target):
    l, r = 0, len(nums) - 1

    while l <= r:
        mid = (l + r) // 2
        elem = nums[mid]
        if target < elem:
            r = mid - 1
        elif target > elem:
            l = mid + 1
        elif target == elem:
            return mid

    return l


if __name__ == "__main__":
    nums = [1, 3, 5, 8, 9]
    target = 4
    print(searchInsert(nums, target))
