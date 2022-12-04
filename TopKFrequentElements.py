def TopKFrequentElems(nums, k):
    hash = {}
    for item in nums:
        if item not in hash:
            hash[item] = 1
        else:
            hash[item] += 1

    values = [[] for i in range(len(nums) + 1)]

    for i in range(0, len(values)):
        for item in hash:
            if hash[item] == i:
                values[i].append(item)

    finalans = []
    for i in range(len(values) - 1, 0, -1):
        for item in values[i]:
            finalans.append(item)
            if len(finalans) == k:
                return finalans


if __name__ == "__main__":
    nums = [1, 1, 1, 2, 2, 3]
    k = 2
    print(TopKFrequentElems(nums, k))
