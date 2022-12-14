def HappyNumber(n):

    if n % 3 != 0 or n == 0:
        return False

    while n % 3 == 0:
        n = n // 3

    return n == 1


if __name__ == "__main__":
    n = 45
    print(HappyNumber(n))
