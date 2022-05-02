def ProductSum(arr, m=1):
    sum = 0
    for item in arr:
        if type(item) is list:
            sum += ProductSum(item, m+1)
        else:
            sum += item
    return sum*m


if __name__ == "__main__":
    arr = [5, 2, [7, -1], 3, [6, [-13, 8], 4]]
    x = ProductSum(arr)
    print(x)
