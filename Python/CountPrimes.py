def countPrimes(n):
    primeArray = [1] * n
    primeArray[0] = 0
    primeArray[1] = 0

    i = 2
    while i < n:
        tmp = i
        if primeArray[i]:
            while tmp < n:
                tmp += i
                primeArray[tmp] = 0
        i += 1

    return sum(primeArray)


if __name__ == "__main__":
    n = 10
    print(countPrimes(n))
