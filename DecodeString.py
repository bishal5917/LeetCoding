def decodeString(s):
    stk = []
    for i in range(0, len(s)):
        if s[i] != "]":
            stk.append(s[i])
        else:
            temp = ""
            while stk[-1] != "[":
                x = stk.pop()
                temp = x + temp
            stk.pop()  # popping the bracket now
            digit = ""
            while stk and stk[-1].isdigit():
                digit = stk.pop() + digit
            stk.append(int(digit) * temp)

    return "".join(stk)


if __name__ == "__main__":
    s = "3[a]2[bc]"
    print(decodeString(s))
