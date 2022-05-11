# Simple Solution with worst time complexity O(2^(n+m))
def NoOfWaysToTraverseGraph(width, height):
    if width == 1 or height == 1:
        return 1

    return NoOfWaysToTraverseGraph(width-1, height)+NoOfWaysToTraverseGraph(width, height-1)


if __name__ == "__main__":
    x = NoOfWaysToTraverseGraph(4, 3)
    print(x)



# a better approach - BY USING DYNAMIC PROGRAMMING
# Time and Space complexity O(n*m)
def NoOfWaysToTraverseGraph(width, height):
    arr = [[0 for i in range(width+1)] for i in range(height+1)]

    for i in range(1, width+1):
        for j in range(1, height+1):
            if i == 1 or j == 1:
                arr[j][i] = 1
            else:
                arr[j][i] = arr[j-1][i]+arr[j][i-1]

    return arr[height][width]


if __name__ == "__main__":
    x = NoOfWaysToTraverseGraph(4, 3)
    print(x)
