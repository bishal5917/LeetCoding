def RunLenEncoding(strr):
    char = []
    length = 1
    for i in range(1, len(strr)):
        if strr[i] != strr[i-1] or length == 9:
            # converting int to string so that we can join at last
            char.append(str(length))
            char.append(strr[i-1])
            length = 1
        elif strr[i] == strr[i-1]:
            length += 1

    # for the last one
    char.append(str(length))
    char.append(strr[len(strr)-1])

    return "".join(char)


if __name__ == "__main__":
    strr = "AAAAAAAAAAAAABBCCCCDD"
    x = RunLenEncoding(strr)
    print(x)
