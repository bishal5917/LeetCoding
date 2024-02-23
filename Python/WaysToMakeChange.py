# We solve using dynamic programming

def WaysToMakeChange(target, coins):
    ways = [0 for i in range(0, target+1)]
    ways[0] = 1  # because to make 0 coins ways = 1 that means not do anything

    for coin in coins:
        for amt in range(0, len(ways)):
            if coin <= amt:
                ways[amt] += ways[amt-coin]

    return ways[target]


if __name__ == "__main__":
    target = 6
    coins = [1, 2, 4]
    x = WaysToMakeChange(target, coins)
    print(x)
