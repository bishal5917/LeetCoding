def LargestBuildingUnderSkyline(arr):
    currMaxArea = 0
    for i in range(0, len(arr)):
        buildCount = 0
        for x in reversed(range(i)):
            if arr[x] >= arr[i]:
                buildCount += 1
            else:
                break
        for y in range(i + 1, len(arr)):
            if arr[y] >= arr[i]:
                buildCount += 1
            else:
                break

        thisArea = (buildCount + 1) * arr[i]
        currMaxArea = max(currMaxArea, thisArea)

    return currMaxArea


if __name__ == "__main__":
    arr = [1, 3, 3, 2, 4, 1, 5, 3, 2]
    print(LargestBuildingUnderSkyline(arr))
