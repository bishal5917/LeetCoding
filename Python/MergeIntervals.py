def MergeIntervals(ivals):
    # sorting by first letter of each of them
    sortedIvals = sorted(ivals, key=lambda x: x[0])
    merged = []
    currentInterval = ivals[0]
    merged.append(currentInterval)

    for nextInterval in sortedIvals:
        if currentInterval[1] >= nextInterval[0]:
            currentInterval[1] = max(currentInterval[1], nextInterval[1])
        else:
            currentInterval = nextInterval
            merged.append(currentInterval)

    return merged


if __name__ == "__main__":
    intervals = [[1, 2], [3, 5], [4, 7], [6, 8], [9, 10]]
    x = MergeIntervals(intervals)
    print(x)
