def PlusMinus():
    arr = [1, 1, 0, -1, -1]
    pos = 0
    neg = 0
    zero = 0
    length = len(arr)

    for item in arr:
        if item > 0:
            pos += 1
        elif item < 0:
            neg += 1
        else:
            zero += 1

    return format(pos/length, ".6f"), format(neg/length, ".6f"), format(zero/length, ".6f")
    # format(num,".6f") prints upto 6 decimal places


x = PlusMinus()
print(x)
