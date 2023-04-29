def addBinary(a, b):
    ans = ""
    carry = 0
    a, b = a[::-1], b[::-1]

    for i in range(max(len(a), len(b))):
        digit1 = ord(a[i]) - ord("0") if i < len(a) else 0
        digit2 = ord(b[i]) - ord("0") if i < len(b) else 0
        total = digit1 + digit2 + carry
        ans = str(total % 2) + ans
        carry = total // 2

    if carry:
        ans="1" + ans
    return ans


if __name__ == "__main__":
    a = "100"
    b = "01"
    print(addBinary(a, b))
