graph = {"1": ["2", "3"], "2": ["4", "5"], "3": ["x"], "4": [], "5": ["x"], "x": []}


def bfs(root):
    visited = [root]
    queue = [root]
    while queue:
        current = queue.pop(0)
        print(current, end=" ")

        for childs in graph[current]:
            if (
                childs not in visited
            ):  # 2ta ko child eutai xa vani tellai kei garna pardena teivara
                queue.append(childs)
                visited.append(childs)


if __name__ == "__main__":
    bfs("1")
