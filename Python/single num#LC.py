def singleNumber(nums):
    result = 0
    for item in nums:
        result = result ^ item
    return result


nums = [4, 1, 2, 1, 2]
print(singleNumber(nums))
# XOR operation done (^)
