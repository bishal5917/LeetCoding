def DiskStacking(disks):
    heights = []
    maxHeightIdx = 0
    sequences = [None for disk in disks]
    for item in disks:
        heights.append(item[2])

    for i in range(0, len(disks)):
        for j in range(0, i):
            if disks[j][0] < disks[i][0] and disks[j][1] < disks[i][1] and disks[j][2] < disks[i][2]:
                heights[i] = max(heights[i], heights[j]+disks[i][2])
                sequences[i] = j

        if heights[i] > heights[maxHeightIdx]:
            maxHeightIdx = i

    return getSequences(disks, sequences, maxHeightIdx)


def getSequences(disks, sequences, currentIdx):
    sequence = []
    while currentIdx is not None:
        sequence.append(disks[currentIdx])
        currentIdx = sequences[currentIdx]
    return sequence


if __name__ == "__main__":
    diskArray = [[2, 2, 1], [2, 1, 2], [3, 2, 3],
                 [2, 3, 4], [4, 4, 5], [2, 2, 8]]
    x = DiskStacking(diskArray)
    print(x)
    DiskStacking(diskArray)
