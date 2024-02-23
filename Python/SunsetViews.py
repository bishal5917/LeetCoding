def SunsetViews(arr):
    stack = []
    i = 0
    while i < len(arr):
        while len(stack) > 0 and arr[stack[-1]] <= arr[i]:
            stack.pop()
        stack.append(i)
        i += 1

    return stack

if __name__ == "__main__":
    buildings = [3, 5, 4, 4, 3, 1, 3, 2]
    # direction is east : so we check for left
    x=SunsetViews(buildings)
    print(x)
