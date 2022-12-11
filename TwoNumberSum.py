# # O(n^2) time complexity and O(1) space
# # Not the optimal solution
# def TwoNumberSum1(arr, target):
#     for i in range(len(arr)):
#         for j in range(i+1, len(arr)):
#             if arr[i]+arr[j] == target:
#                 return [arr[i], arr[j]]


# arr = [5, 1, 12, 7, 3, 9]
# print(TwoNumberSum1(arr, 14))


# # O(n) time complexity and O(n) space
# def TwoNumberSum2(arr, target):
#     hash = []
#     for item in arr:
#         if (target-item) not in hash:
#             hash.append(item)
#         else:
#             return [item, target-item]

#     return False


# arr = [8, 2, 9, 5, 10, 1]
# print(TwoNumberSum2(arr, 12))


# # O(n) time complexity and O(n) space
# # O(nlog(n)) time and O(n) space
# # My favourite solution
# def TwoNumberSum3(arr, target):
#     arr.sort()
#     firstIdx = 0
#     lastIdx = len(arr)-1

#     while (firstIdx < lastIdx):
#         if (arr[firstIdx]+arr[lastIdx] < target):
#             firstIdx += 1
#         elif (arr[firstIdx]+arr[lastIdx] > target):
#             lastIdx -= 1
#         else:
#             return [arr[firstIdx], arr[lastIdx]]


# arr = [5, 1, 12, 7, 3, 9]
# print(TwoNumberSum3(arr, 14))

# LeetCode
def twoSum(nums, target):
    arr=[]
    for item in nums:
        arr.append(item)
    nums.sort()
    firstIdx = 0
    lastIdx = len(nums) - 1

    while firstIdx < lastIdx:
        if nums[firstIdx] + nums[lastIdx] < target:
            firstIdx += 1
        elif nums[firstIdx] + nums[lastIdx] > target:
            lastIdx -= 1
        else:
            return [firstIdx, lastIdx]


nums = [3, 2, 3]
target = 6
print(twoSum(nums, target))
