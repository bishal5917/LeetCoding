def countingmachine(arr, n):
    h = []  # creating an empty list
    count = 0  # iniitializing counter to zero

    # checking if element of array is in h or not
    for i in range(n):
        if (arr[i] not in h):
            h.append(arr[i])
            count = count+1
    return print("THE COUNT IS ", count)


if __name__ == "__main__":
    arr = []
# taking one element and appending at the end of the empty list
    n = int(input("Enter number of elements  "))
    for j in range(0, n):
        value = int(input())
        arr.append(value)
# calling the function
    (countingmachine(arr, n))
