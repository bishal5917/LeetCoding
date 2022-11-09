def DivideTwoIntegers(dividend, divisor):
    a = dividend
    b = divisor
    count = 0
    if divisor == 0:
        return -1
    if dividend == 0:
        return 0

    while abs(dividend) >= abs(divisor):
        dividend = abs(dividend) - abs(divisor)
        count += 1

    if a > 0 and b > 0:
        return count
    if a < 0 or b < 0:
        return 0 - count
    if a < 0 and b < 0:
        return count


if __name__ == "__main__":
    dividend = -1
    divisor = 1
    print(DivideTwoIntegers(dividend, divisor))
