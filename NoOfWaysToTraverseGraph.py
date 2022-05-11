# Simple Solution with worst time complexity O(2^(n+m))
def NoOfWaysToTraverseGraph(width, height):
    if width == 1 or height == 1:
        return 1

    return NoOfWaysToTraverseGraph(width-1, height)+NoOfWaysToTraverseGraph(width, height-1)


if __name__ == "__main__":
    x = NoOfWaysToTraverseGraph(4, 3)
    print(x)
