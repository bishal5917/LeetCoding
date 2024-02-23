def TaskAssignment(task):
    indexTrack = {}
    final = []

    for idx, item in enumerate(task):
        if item in indexTrack:
            indexTrack[item].append(idx)
        else:
            indexTrack[item] = [idx]

    sortedTask = sorted(task)
    fidx = 0
    lidx = len(task)-1
    while(fidx < lidx):
        a = sortedTask[fidx]
        b = sortedTask[lidx]
        final.append([indexTrack[a].pop(), indexTrack[b].pop()])
        fidx += 1
        lidx -= 1

    return final


if __name__ == "__main__":
    tasks = [1, 3, 5, 3, 1, 4]
    x = TaskAssignment(tasks)
    print(x)
