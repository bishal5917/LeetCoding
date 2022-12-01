def UnderscorifySubstring(str, substr):
    getLocations = [[0, 4], [10, 14], [14, 18], [20, 24], [23, 27], [26, 30]]

    
    # code to overlap locations
    mergedLocations = [getLocations[0]]
    previous = mergedLocations[0]
    for i in range(1, len(getLocations)):
        current = getLocations[i]
        if current[0] <= previous[1]:
            previous[1] = current[1]
        else:
            mergedLocations.append(current)
            previous = current
    print(mergedLocations)


if __name__ == "__main__":
    str = "testthis is a testtest to see if testestest it works"
    substr = "test"
    UnderscorifySubstring(str, substr)
