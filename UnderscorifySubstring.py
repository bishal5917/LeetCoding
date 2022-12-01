def UnderscorifySubstring(str, substr):
    # code to get locations of substring on main string
    locations = []
    startIdx = 0
    while startIdx < len(str):
        nextIdx = str.find(substr, startIdx)
        if nextIdx != -1:
            locations.append([nextIdx, nextIdx + len(substr)])
            startIdx = nextIdx + 1
        else:
            break

    # code to overlap locations if any
    mergedLocations = [locations[0]]
    previous = mergedLocations[0]
    for i in range(1, len(locations)):
        current = locations[i]
        if current[0] <= previous[1]:
            previous[1] = current[1]
        else:
            mergedLocations.append(current)
            previous = current

    # print(locations)
    # print(mergedLocations)
    

if __name__ == "__main__":
    str = "testthis is a testtest to see if testestest it works"
    substr = "test"
    UnderscorifySubstring(str, substr)
