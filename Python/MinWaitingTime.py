def MinWaitingTime(query):
    # We have to find the minimum waiting time for the query to be executed
    query.sort()
    MinWait = 0

    for i in range(1, len(query)):
        CurrentWait = query[i-1]*(len(query)-i)
        MinWait += CurrentWait

    return MinWait


if __name__ == "__main__":
    query = [3, 2, 1, 2, 6]
    x = MinWaitingTime(query)
    print(x)
