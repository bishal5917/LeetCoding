# BruteForce Solution
# O(n^4) time
def MaximizeExpression(arr, target):
    for a in range(0, len(arr)):
        for b in range(a, len(arr)):
            for c in range(b, len(arr)):
                for d in range(c, len(arr)):
                    if (
                        arr[a] - arr[b] + arr[c] - arr[d] == target
                        and a < b
                        and b < c
                        and c < d
                    ):
                        return a, b, c, d


if __name__ == "__main__":
    arr = [3, 6, 1, -3, 2, 7]
    print(MaximizeExpression(arr, 4))
