nums = [2, 2, 4, 4, 1, 1, 1, 65, 65, 2, 45]
# we have to find the number that appears exactly one time
# here is 45

list = []
# making a list with all the numbers without repeating
for num in nums:
    if num not in list:
        list.append(num)

# checking the count of numbers of our list in original given list
for item in list:
    # printing if count is exactly one
    if nums.count(item) == 1:
        print(item)
