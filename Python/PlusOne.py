def PlusOne(s):
    num = ""
    for item in s:
        num = num + str(item)

    sum = int(num) + 1

    output = []
    for item in str(sum):
        output.append(int(item))

    return output


if __name__ == "__main__":
    s = [1, 2, 3]
    s = [0, 0]
    print(PlusOne(s))
