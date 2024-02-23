def KnapSack(items, capacity):
    # we are going to solve this using dynamic programming
    # so lets make an array
    knapSackValues = [[0 for x in range(0, capacity+1)]
                      for y in range(0, len(items)+1)]

    # so lets change the values in array dynamically
    for i in range(1, len(items)+1):
        # we are doing from 1 because first row will be all 0
        currentValue = items[i-1][0]
        currentWeight = items[i-1][1]
        for c in range(0, capacity+1):
            if currentWeight > c:
                knapSackValues[i][c] = knapSackValues[i-1][c]
            else:
                knapSackValues[i][c] = max(knapSackValues[i-1][c],
                                           knapSackValues[i-1][c-currentWeight]+currentValue)

    return knapSackValues


def getItem(KnapSackValues, items):
    sequence = []
    i = len(KnapSackValues)-1
    c = len(KnapSackValues[0])-1
    # we pointing i c at last one of KnapSackValues[-1][-1]
    # Then we will backtrack from there
    while i > 0:
        if KnapSackValues[i][c] == KnapSackValues[i-1][c]:
            i -= 1
        else:
            sequence.append(i-1)
            c -= items[i-1][1]
            i -= 1
            if c == 0:
                break
    return sequence


if __name__ == "__main__":
    itemArray = [[1, 2], [4, 3], [5, 6], [6, 7]]
    final2dArray = KnapSack(itemArray, 10)
    finalReturned = getItem(final2dArray, itemArray)
    print(finalReturned)
