
def ThreeNumSum(targetSum):
    arr = [-8, -6, 1, 2, 3, 5, 6, 12]
    arr.sort()

    for i in range(len(arr)-2):
        leftIdx = i+1
        rightIdx = len(arr)-1
        while(leftIdx < rightIdx):
            if (arr[i]+arr[leftIdx]+arr[rightIdx] == targetSum):
                print(arr[i], arr[leftIdx], arr[rightIdx])
                leftIdx += 1
                rightIdx -= 1
            elif (arr[i]+arr[leftIdx]+arr[rightIdx] < targetSum):
                leftIdx += 1
            elif (arr[i]+arr[leftIdx]+arr[rightIdx] > targetSum):
                rightIdx -= 1


ThreeNumSum(0)
