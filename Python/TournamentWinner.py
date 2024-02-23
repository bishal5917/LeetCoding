def TournamentWinner(comp, results):
    winnerHash = {}
    idx = 0
    while (idx < len(comp)):
        if results[idx] == 0:
            x = comp[idx][1]
            if x in winnerHash:
                winnerHash[x] += 3
            else:
                winnerHash[x] = 3
        elif results[idx] == 1:
            y = comp[idx][0]
            if y in winnerHash:
                winnerHash[y] += 3
            else:
                winnerHash[y] = 3
        idx += 1

    # Now Determining the winning team from the hash
    currentbest = 0
    currentwinning = ""
    for item in winnerHash:
        if winnerHash[item] > currentbest:
            currentbest = winnerHash[item]
            currentwinning = item

    return currentwinning


if __name__ == "__main__":
    competitions = [["HTML", "C#"],
                    ["C#", "Python"],
                    ["Python", "HTML"]]
    results = [0, 0, 1]
    x = TournamentWinner(competitions, results)
    print(x)
