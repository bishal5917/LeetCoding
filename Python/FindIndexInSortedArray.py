
def find(target):
    arr = [2, 4, 5, 5, 5, 5, 5, 5, 7, 9, 9]

    for item in arr:
        if item == target:
            idx = arr.index(target)

    first = idx
    last = first

    while last < len(arr) and arr[last] == target:
        last += 1

    return first, last-1


print(find(5))
