def CycleInGraph(graph):
    visited = [False for _ in graph]
    inCallStack = [False for _ in graph]

    for node in range(len(graph)):
        if visited[node]:
            continue

        isCycle = DFS(node, graph, visited, inCallStack)
        if isCycle:
            return True

    return False


def DFS(node, graph, visited, inCallStack):
    # Here the logic used is if for a particular node,if its any of the neighbor is
    # in the call stack,then there must be a cycle.Means the descendant is connected to its ancestor,
    # so there's a cycle
    visited[node] = True
    inCallStack[node] = True
    neighbors = graph[node]
    for neighbor in neighbors:
        if not visited[neighbor]:
            isCycle = DFS(neighbor, graph, visited, inCallStack)
            if isCycle:
                return True
        elif inCallStack[neighbor]:
            return True

    inCallStack[node] = False
    return False


if __name__ == "__main__":
    graph = [[1, 3], [2, 3, 4], [0], [], [2, 5], []]
    print(CycleInGraph(graph))
