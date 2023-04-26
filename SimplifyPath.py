def simplifyPath(path):
    stack = []
    currStr = ""

    for item in path+"/":
        if item == "/":
            if currStr == "..":
                if stack:
                    stack.pop()
            elif currStr != "" and currStr != ".":
                stack.append(currStr)
            currStr = ""
        else:
            currStr += item

    return "/" + "/".join(stack)


if __name__ == "__main__":
    path = "/home"
    print(simplifyPath(path))
