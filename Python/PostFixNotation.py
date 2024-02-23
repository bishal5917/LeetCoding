def PostFixNotation(tokens):
    stack = []
    operators = {"+", "-", "*", "/"}
    for item in tokens:
        if item not in operators:
            stack.append(int(item))
        else:
            if item == "+":
                stack.append(stack.pop() + stack.pop())
            if item == "*":
                stack.append(stack.pop() * stack.pop())
            if item == "/":
                firstPopped = stack.pop()
                secondPopped = stack.pop()
                calculated = int(secondPopped / firstPopped)
                stack.append(calculated)
            if item == "-":
                firstPopped = stack.pop()
                secondPopped = stack.pop()
                calculated = secondPopped - firstPopped
                stack.append(calculated)

    return stack[0]


if __name__ == "__main__":
    tokens = ["10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"]
    print(PostFixNotation(tokens))
