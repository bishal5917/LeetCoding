def UnderscorifySubstring(str, substr):
    getLocations = [[0, 4], [10, 14], [14, 18], [20, 24], [23, 27], [26, 30]]
    # code to overlap locations
    # for x in range(2):
    for i in range(1, len(getLocations) - 2):
        if getLocations[i][0] <= getLocations[i - 1][1]:
            getLocations[i - 1][1] = getLocations[i][1]
            getLocations.pop(i)
    print(getLocations)


if __name__ == "__main__":
    str = "testthis is a testtest to see if testestest it works"
    substr = "test"
    UnderscorifySubstring(str, substr)
