import math


def PerfectSquares(n):
    if checkPerfectSquare(n):
        return 1
    for i in range(1, n):
        result = n - i
        if checkPerfectSquare(result) and checkPerfectSquare(i):
            return 2
        if checkPerfectSquare(i) and checkPerfectSquare(result) == False:
            return 1 + checkPerfectSquare(result)


def checkPerfectSquare(num):
    if num % math.sqrt(num) == 0:
        return True
    return False


if __name__ == "__main__":
    n = 12
    print(PerfectSquares(n))
    # print(checkPerfectSquare(9))
