# O(N) Time and O(1) Space
def IndexEqualsValue(arr):
    for i in range(0, len(arr)):
        if i == arr[i]:
            return i


# O(log(N)) Time and O(1) Space
# Note : Given Array should be sorted
def IndexEqualsValueOptimal(arr):
    for i in range(0, len(arr)):
        if i == arr[i]:
            return i


if __name__ == "__main__":
    arr = [-5, -3, 0, 3, 4, 7, 9]
    # print(IndexEqualsValue(arr))
