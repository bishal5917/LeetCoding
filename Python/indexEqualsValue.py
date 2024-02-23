# O(N) Time and O(1) Space
def IndexEqualsValue(arr):
    for i in range(0, len(arr)):
        if i == arr[i]:
            return i


# O(log(N)) Time and O(log(N)) Space
# If Done by iteration this could have been in O(log(N)) time and O(1) space
# Note : Given Array should be sorted
def IndexEqualsValueOptimal(arr, left, right):
    if left > right:
        return 0
    mid = (left + right) // 2
    if arr[mid] == mid and mid == 0:
        return mid
    if arr[mid] == mid and arr[mid - 1] < mid - 1:
        return mid
    elif arr[mid] < mid:
        return IndexEqualsValueOptimal(arr, mid + 1, right)
    elif arr[mid] > mid:
        return IndexEqualsValueOptimal(arr, left, mid - 1)


if __name__ == "__main__":
    arr = [-5, -3, 0, 1, 2, 4, 6]
    print(IndexEqualsValue(arr))
    print(IndexEqualsValueOptimal(arr, 0, len(arr) - 1))
