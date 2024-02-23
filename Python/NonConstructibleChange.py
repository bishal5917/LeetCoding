def NonConstructibleChange(coins):
    # Here we have to find the minimum change that cannot be made using the given coins array
    # one coin cannot be used twice
    change = 0
    coins.sort()
    for item in coins:
        if not item > change+1:
            change = change+item

    return change+1


if __name__ == "__main__":
    coins = [5, 7, 1, 1, 2, 3, 22]
    # ans will be 20
    x = NonConstructibleChange(coins)
    print(x)
