
def MinMaxSum():
    sum = []
    array = [1, 2, 3, 4, 5]
    i = 0
    itemSum = 0

    while (i < len(array)):
        x = array.pop(i)
        newArray = array
        for items in newArray:
            itemSum += items
        sum.append(itemSum)
        i += 1

    return sum
    # array.pop(1)
    # return array


print(MinMaxSum())
