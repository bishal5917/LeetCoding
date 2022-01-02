
def myFunc():
    x = [17, 28, 30]
    y = [99, 16, 8]
    forx = 0
    fory = 0
    indexi = 0
    indexj = 0

    while (indexi < len(x) and indexj < len(y)):
        if x[indexi] > y[indexj]:
            forx += 1
            indexi += 1
            indexj += 1
        elif x[indexi] < y[indexj]:
            fory += 1
            indexi += 1
            indexj += 1
        else:
            indexi += 1
            indexj += 1

    return forx, fory


x = myFunc()
print(x)
