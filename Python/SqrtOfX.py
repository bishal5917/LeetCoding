def mySqrt(x):
    first = 0
    last = x

    while first + 1 < last:
        mid = first + (last - first) // 2
        if mid * mid == x:
            return mid
        elif mid * mid > x:
            last = mid
        elif mid * mid < x:
            first = mid

    if last * last == x:
        return last

    return first


if __name__ == "__main__":
    x = 8
    print(mySqrt(x))
