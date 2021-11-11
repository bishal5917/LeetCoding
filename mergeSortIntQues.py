def mergemethod(array):
    if len(array) == 1:
        return array
    midIndex = len(array)//2
    leftSubArray = array[:midIndex]
    rightSubArray = array[midIndex:]
    return mergeAfterSorting(mergemethod(leftSubArray), mergemethod(rightSubArray))


def mergeAfterSorting(leftSubArray, rightSubArray):
    sortedArray = []
    i = j = 0
    k=0
  
    while (i < len(leftSubArray) and j < len(leftSubArray)):
        if leftSubArray[i] <= rightSubArray[j]:
            sortedArray[k]=leftSubArray[i]
            i += 1
        else:
            sortedArray[k]=rightSubArray[j]
            j +=1

    while(i < len(leftSubArray)):
        sortedArray[k] = leftSubArray[i]
        i += 1
        k += 1

    while(j < len(rightSubArray)):
        sortedArray[k] = rightSubArray[j]
        k+=1
        j += 1
    return sortedArray


if __name__ == "__main__":
    arrayToSort = [2, 4, 1, 66, 35, 56, 5]
    print(mergemethod(arrayToSort))
