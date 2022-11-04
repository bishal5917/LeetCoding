# BruteForce Solution
# O(n^4) time
# Expression is a-b+c-d
def MaximizeExpression(arr):
    currentMax = 0
    for a in range(0, len(arr)):
        for b in range(a, len(arr)):
            for c in range(b, len(arr)):
                for d in range(c, len(arr)):
                    if a < b and b < c and c < d:
                        currentMax = max(arr[a] - arr[b] + arr[c] - arr[d], currentMax)

    return currentMax


# Using Dynamic Programming
# O(n) time and O(n) space
def MaximizeExpressionOptimal(arr):
    a = [item for item in arr]
    ab = [0 for _ in arr]
    abc = [0 for _ in arr]
    abcd = [0 for _ in arr]
    for i in range(1, len(arr)):
        # max of a
        a[i] = max(arr[i], a[i - 1])

    for i in range(1, len(arr)):
        # max of a-b
        ab[i] = max(a[i - 1] - arr[i], ab[i - 1])

    for i in range(2, len(arr)):
        # max of a-b+c
        abc[i] = max(ab[i - 1] + arr[i], abc[i - 1])

    for i in range(3, len(arr)):
        # max of a-b+c-d
        abcd[i] = max(abc[i - 1] - arr[i], abcd[i - 1])

    return abcd[len(arr) - 1]


if __name__ == "__main__":
    arr = [3, 6, 1, -3, 2, 7]
    print(MaximizeExpression(arr))
    print(MaximizeExpressionOptimal(arr))
