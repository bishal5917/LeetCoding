def maxProfit(prices):
    buy = 0
    sell = 1
    maxProfit = 0
    while buy < len(prices) and sell < len(prices):
        currProfit = prices[sell] - prices[buy]
        maxProfit = max(maxProfit, currProfit)
        if currProfit < 0:
            buy = sell
            sell += 1
        else:
            sell += 1

    return maxProfit


if __name__ == "__main__":
    prices = [7, 1, 5, 3, 6, 4]
    # prices = [7, 6, 4, 3, 1]
    print(maxProfit(prices))
