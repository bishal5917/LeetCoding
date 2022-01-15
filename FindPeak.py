# O(log(n)) time complexity and O(1) space complexity
def PeakFinding(arr):
    left = 0
    right = len(arr)-1
    while left < right:
        mid = (left+right)//2
        if arr[mid] <= arr[mid+1]:
            left = mid+1
        else:
            right = mid

    return arr[left]


arr = [1, 3, 9, 10, 5, 2, 6, 7, 4]
print("Peak Number is", PeakFinding(arr))
