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

    print(knapSackValues[-1][-1])


if __name__ == "__main__":
    itemArray = [[1, 2], [4, 3], [5, 6], [6, 7]]
    KnapSack(itemArray, 10)
