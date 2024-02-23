def SortedSquaredArray(arr):
    st = 0
    end = len(arr)-1
    ans = [0 for item in arr]
    i = len(arr)-1
    while st < end:
        if abs(arr[st]) < abs(arr[end]):
            ans[i] = arr[end]*arr[end]
            i -= 1
            end -= 1
        elif abs(arr[st]) > abs(arr[end]):
            ans[i] = arr[st]*arr[st]
            i -= 1
            st += 1

    if st == end:
        ans[0] = arr[st]*arr[st]

    return ans


if __name__ == "__main__":
    arr = [-7, -5, -4, 3, 6, 8, 9, 10]
    x = SortedSquaredArray(arr)
    print(x)
