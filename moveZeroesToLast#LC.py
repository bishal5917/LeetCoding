def moveZeroes(nums):

    for item in nums:
        if item == 0:
            nums.remove(item)
            nums.append(0)

    return nums


if __name__ == "__main__":
    nums = [0, 1, 0, 3, 12]
    print(moveZeroes(nums))
