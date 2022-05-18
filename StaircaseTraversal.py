# O(k^n) time where k=height and n=maxsteps and O(n) space
def StaircaseTraversal(height, maxsteps):
    if height == 0 or height == 1:
        return 1

    noOfWays = 0
    for step in range(1, min(maxsteps, height)+1):
        noOfWays += StaircaseTraversal(height-step, maxsteps)

    return noOfWays


if __name__ == "__main__":
    height = 4
    maxsteps = 2
    print(StaircaseTraversal(height, maxsteps))


# O(k*n) time where k=height and n=maxsteps and O(n) space
def StaircaseTraversal(height, maxsteps, memoize):
    if height in memoize:
        return memoize[height]

    noOfWays = 0
    for step in range(1, min(maxsteps, height)+1):
        noOfWays += StaircaseTraversal(height-step, maxsteps, memoize)

    memoize[height] = noOfWays

    return noOfWays


if __name__ == "__main__":
    memo = {0: 1, 1: 1}
    height = 4
    maxsteps = 2
    print(StaircaseTraversal(height, maxsteps, memo))
