def solveMaze(maze, x, y, path):
    if x == len(maze[0]) - 1 and y == len(maze) - 1:
        path[x][y] = 1
        return True

    if (x < len(maze[0])) and (y < len(maze)) and maze[x][y] == 1:
        path[x][y] = 1
        if solveMaze(maze, x + 1, y, path):
            return True, path
        if solveMaze(maze, x, y + 1, path):
            return True, path
        path[x][y] = 0
        return False

    return False


if __name__ == "__main__":
    maze = [
        [1, 0, 1, 0, 1],
        [1, 1, 1, 1, 1],
        [0, 1, 0, 1, 0],
        [1, 0, 0, 1, 1],
        [1, 1, 1, 0, 1],
    ]
    path = [[0 for i in range(0, len(maze[0]))] for j in range(0, len(maze))]
    print(solveMaze(maze, 0, 0, path))
