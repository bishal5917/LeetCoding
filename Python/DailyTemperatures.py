def dailyTemperatures(temperatures):
    output = [0 for _ in range(0, len(temperatures))]
    stack = []

    for idx,val in enumerate(temperatures):
        while len(stack)>0 and stack[-1][1]<val:
            sIdx,sVal=stack.pop()
            output[sIdx]=idx-sIdx
        stack.append([idx,val])

    return output


if __name__ == "__main__":
    temps = [73, 74, 75, 71, 69, 72, 76, 73]
    print(dailyTemperatures(temps))
