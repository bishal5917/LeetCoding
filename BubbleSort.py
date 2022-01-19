
def BubbleSort(arr):
    iters = 0
    while iters < len(arr):
        i = 0
        while i < len(arr)-1:
            if arr[i] > arr[i+1]:
                arr[i], arr[i+1] = arr[i+1], arr[i]

            i += 1
        iters += 1
    return arr


arr = [5, 1, 4, 9, 8, 34, 30]
print(BubbleSort(arr))
