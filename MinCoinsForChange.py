# We solve using dynamic programming

def MinNumberOfCoins(target, coins):
    array = [float("inf") for i in range(0, target+1)]
    array[0] = 0  # because to make 0 coins we need 0 (base case)

    for coin in coins:
        for amt in range(0, len(array)):
            if coin <= amt:
                array[amt] = min(array[amt], 1+array[amt-coin])

    return array[target]


if __name__ == "__main__":
    target = 6
    coins = [1, 2, 4]
    x = MinNumberOfCoins(target, coins)
    print(x)
