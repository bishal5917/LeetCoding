# FInd Sum of two integers without using plus and -
def SumOfTwoIntegers(a, b):
    # this works for positive numbers only
    # count = []
    # for _ in range(a):
    #     count.append(0)
    # for _ in range(b):
    #     count.append(0)

    # return len(count)

    mask = 0xFFFFFFFF

    while b != 0:
        tmp = (a & b) << 1
        a = (a ^ b) & mask
        b = tmp & mask

    if a > mask // 2:
        return ~(a ^ mask)
    else:
        return a


if __name__ == "__main__":
    a = -1
    b = 1
    print(SumOfTwoIntegers(a, b))
