
def findKLargest(K):
    array = [1, 2, 3, 4, 5]
    array.sort()

    return array[::-1][K-1]


print(findKLargest(3))
