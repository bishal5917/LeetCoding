# x=float("inf")
# print(x)
# print(x>21)

# array=[1]
# array.append([1]+[2])
# print(array)

# even = [1, 7]
# odd = [6, 8]
# maxFind1 = max(even, odd)  # this doesnot do subtraction(watches the last)
# maxFind2 = max(even, odd, key=lambda x: x[1]-x[0])  # this do by subtracting
# # Note : key is keyword argument for max()
# print(maxFind1, maxFind2)

# array=[[3,4,1,9],
#          [1,3,4,6]]
# print(array[-1][-1])

# arr=[0,3,4,5]
# for i in range(0,0):
#     print(arr[i])

# hash={}
# arr=[2,3,4,5]
# hash[5]=[[arr[0],arr[1]]]
# print(hash)
# hash[5].append([2,3])
# print(hash)

# arr = [2, 3, 4, 5]
# for i in reversed(range(len(arr))):
#     print(arr[i])

# arr = [2, 3, 4, 5]
# # for i in range(0,len(arr)):
# #     print(i)
# if 5 in arr:
#     print(True)

# arr = [2, 3, 4, 5]
# for i in reversed(range(2+1)):
#     print(arr[i])

# 1 - 1
# 2 - 10
# 3 - 100
# 4 - 1000
# print(pow(10, n - 1))
# num = 8762
# p = 4
# x = (num // (pow(10, (p - 1)))) % 10
# print(x)

# getLocations = [[0, 4], [10, 14], [14, 18], [20, 24], [23, 27], [26, 30]]

# getLocations.pop(0)
# getLocations[1][0] = getLocations[2][1]
# print(getLocations)

# nums = [1,2,3,4,5,6,7]
# last=nums[-1]
# print(last)

# nums = [1,2,3,4,5,6,7]
# nums.reverse()
# print(nums)

# print(3%3)
# print(4%2)

# nums = [1, 2]
# print(nums.pop(1))
# print(4 + 5 // 13)
# print(math.trunc(13 / 5))

# nums = [[], [3], [2], [1], [], [], []]
# for i in range(len(nums) - 1, 0, -1):
#     print(nums[i])

# mask = 0xFFFFFFFF
# print(mask)
# a=2
# b=3
# tmp = (a & b)<<1
# print(tmp)

# nhs=[4,4,3]
# fourCount=0
# for item in nhs:
#     if item==4:
#         fourCount+=1
# print(len(nhs)==fourCount)

# nhs = [[1, 0], [1, 1], [1, 2]]
# ok = [[1, 0], [2, 1]]
# for item in ok:
#     if item in nhs:
#         print(True)
#     else:
#         print(False)

# nhs = [[1, 0], [1, 1], [1, 2]]
# ok = nhs.pop(0)
# print(ok)

# print(2023 % 4)
# print(1900 % 4)
# print(1900 % 100)

# a=[5,6,7,8]
# i=2
# a.remove(a[i])
# a.append(0)
# print(a[i])

# print(0 + 4 // 2)
# print(27//3)
# print(9//3)
# print(3//3)

# print(2%5)
# class Node:
#     def __init__(self, row, col, value):
#         self.id = str(row) + "-" + str(col)
#         self.row = row
#         self.col = col
#         self.value = value
#         self.g_score = float("inf")
#         self.f_score = float("inf")
#         self.previous = None


# grid = [
#     [1, "S", 1, 1, 1],
#     [1, "#", "#", "#", 1],
#     [1, 1, 1, 1, 1],
#     ["#", 1, "#", "#", "#"],
#     [1, 1, 1, "E", 1],
# ]

# nodes = []

# for i, row in enumerate(grid):
#     nodes.append([])
#     # print(i,row)
#     for j, value in enumerate(row):
#         print(j, value)
#         nodes[i].append(Node(i, j, value))

# print(nodes)

# str="a"
# str+="bc"
# print(str)