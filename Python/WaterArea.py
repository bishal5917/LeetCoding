
def WaterArea(wa):
    # calculating the Leftmax array
    leftMax = [0 for i in range(len(wa))]
    leftMax[0] = 0
    currLeftMax = 0

    for i in range(0, len(wa)):
        height = wa[i]
        leftMax[i] = currLeftMax
        currLeftMax = max(currLeftMax, height)

    # calculating the rightmax array
    rightMax = [0 for i in range(len(wa))]
    rightMax[len(wa)-1] = 0
    currRtMax = 0

    for i in reversed(range(len(wa))):
        heighta = wa[i]
        rightMax[i] = currRtMax
        currRtMax = max(currRtMax, heighta)

    a = 0  # pointer
    output = [0 for i in range(len(wa))]
    while (a < len(wa)):
        minn = min(leftMax[a], rightMax[a])
        if wa[a] < minn:
            output[a] = minn-wa[a]
        else:
            output[a] = 0
        a += 1

    return sum(output)


if __name__ == "__main__":
    WaterArray = [0, 8, 0, 0, 5, 0, 0, 10, 0, 0, 1, 1, 0, 3]
    x = WaterArea(WaterArray)
    print(x)
