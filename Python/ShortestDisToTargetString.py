def shortestDis(words, target, startIndex):

    if target not in words:
        return -1
    if words[startIndex] == target:
        return 0
    path = float("inf")
    n = len(words)

    # checking right
    i = startIndex
    count = 0
    prev = (i - 1 + n) % n
    while i != prev:
        if i < n:
            i = (i + 1) % n
            count += 1
            if words[i] == target:
                path = min(path, count)

    # checking left
    i = startIndex
    count = 0
    next = (i + 1) % n
    while i != next:
        if i < n:
            i = (i - 1 + n) % n
            count += 1
            if words[i] == target:
                path = min(path, count)

    return path


if __name__ == "__main__":
    words = [
        "hsdqinnoha",
        "mqhskgeqzr",
        "zemkwvqrww",
        "zemkwvqrww",
        "daljcrktje",
        "fghofclnwp",
        "djwdworyka",
        "cxfpybanhd",
        "fghofclnwp",
        "fghofclnwp",
    ]
    target = "zemkwvqrww"
    startIndex = 8
    print(shortestDis(words, target, startIndex))
