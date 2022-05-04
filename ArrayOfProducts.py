def AOP(arr):
    prods = [1 for item in arr]
    for i in range(0, len(arr)):
        runningProd = 1
        for j in range(0, len(arr)):
            if i != j:
                runningProd = runningProd*arr[j]
        prods[i] = runningProd

    return prods


if __name__ == "__main__":
    arr = [5, 1, 4, 2]
    x = AOP(arr)
    print(x)
