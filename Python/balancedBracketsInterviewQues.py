def isValid(s):
    match = {"(": ")", "{": "}", "[": "]"}
    open = "({["
    closed = ")}]"
    st = []

    if s[0] in closed:
        return False

    for item in s:
        if item in open:
            st.append(item)
        if item in closed and len(st) != 0:
            lastOne = st[-1]
            if match[lastOne] == item:
                st.pop()
            elif match[lastOne] != item:
                return False
        if item in closed and len(st) == 0:
            return False

    if len(st) == 0:
        return True
    else:
        return False


# s = "(]"
# s = "()[]{}"
s = "]"
# s = "(){}}{"
s = "(])"
s = "[])"
print(isValid(s))
