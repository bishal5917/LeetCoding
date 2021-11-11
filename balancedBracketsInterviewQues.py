
def bb(string):
    openingbrackets = "([{"
    closingbrackets = ")}]"
    matchingbrackets = {")": "(", "]": "[", "}": "{"}

    stack = []
    for char in string:
        if char in openingbrackets:
            stack.append(char)
        elif char in closingbrackets:
            if len(stack) == 0:
                print("unbalanced")
            if stack[-1] == matchingbrackets[char]:
                stack.pop()
                # stack.pop()
            else:
                print("not balanced")

    if len(stack) == 0:
        print("balanced")


bb("{[][[[{]}")
