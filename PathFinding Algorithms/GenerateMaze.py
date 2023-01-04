import random


def GenerateMaze(grid):
    noOfObstacles = (len(grid) * len(grid[0])) // 3

    for _ in range(0, noOfObstacles):
        one = random.randint(0, len(grid) - 1)
        two = random.randint(0, len(grid[0]) - 1)
        if grid[one][two] == 1:
            grid[one][two] = "#"

    print(grid)


if __name__ == "__main__":
    grid = [
        [1, "S", 1, 1, 1],
        [1, 1, 1, 1, 1],
        [1, 1, 1, 1, 1],
        [1, 1, 1, 1, 1],
        [1, 1, 1, 1, "E"],
    ]
    GenerateMaze(grid)
