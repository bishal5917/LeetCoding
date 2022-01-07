# x=float("inf")
# print(x)
# print(x>21)

# array=[1]
# array.append([1]+[2])
# print(array)

even = [1, 7]
odd = [6, 8]
maxFind1 = max(even, odd)  # this doesnot do subtraction(watches the last)
maxFind2 = max(even, odd, key=lambda x: x[1]-x[0])  # this do by subtracting
# Note : key is keyword argument for max()
print(maxFind1, maxFind2)
