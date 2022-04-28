def FindLeftIndex(arr, target):
    left = 0
    right = len(arr)-1
    mid = (left+right)//2
    while left <= right:
        if arr[mid] == target and arr[mid-1] == target:
            right = mid
            mid = (left+right)//2
        if arr[mid] != target and arr[mid] < target:
            left = mid
            mid = (left+right)//2
        if arr[mid] == target and arr[mid-1] != target:
            return mid


def FindRightIndex(arr, target):
    left = 0
    right = len(arr)-1
    mid = (left+right)//2
    while left <= right:
        if arr[mid] == target and arr[mid+1] == target:
            left = mid
            mid = (left+right)//2
        if arr[mid] != target and arr[mid] > target:
            right = mid
            mid = (left+right)//2
        if arr[mid] == target and arr[mid+1] != target:
            return mid
        if mid == len(arr)-1 or arr[mid+1] != target:
            return mid


if __name__ == "__main__":
    givenArray = [7, 8, 35, 45, 45, 45, 45, 45, 45, 45, 45, 75]
    target = 45
    left = FindLeftIndex(givenArray, target)
    right = FindRightIndex(givenArray, target)
    print(left, right)
