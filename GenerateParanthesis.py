# A classic backtracking problem
def GenerateParanthesis(n):
    output = []
    stack = []
    return ParanthesisGenerator(output, stack, n, 0, 0)


def ParanthesisGenerator(output, stack, n, closedP, openedP):
    if n == closedP == openedP:
        output.append("".join(stack))
        return
    if openedP < n:
        stack.append("(")
        ParanthesisGenerator(output, stack, n, closedP, openedP + 1)
        stack.pop()
    if closedP < openedP:
        stack.append(")")
        ParanthesisGenerator(output, stack, n, closedP + 1, openedP)
        stack.pop()
    return output


if __name__ == "__main__":
    n = 2
    print(GenerateParanthesis(n))
