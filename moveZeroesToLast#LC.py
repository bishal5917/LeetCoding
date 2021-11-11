nums=[1,0,0,8,0,0,8,6,0,4,5,7]

# counting the number of zeroes in a list
count_0=nums.count(0)
# print(count_0)

next=[]
# appending non-zeroes nums in an empty list
for item in nums:
    if item != 0:
        next.append(item)

# finally appending all those zeroes at last
for i in range(count_0):
    next.append(0)

# printing our final ans
print(next)