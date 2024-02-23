def diagonalDiff():
    Arr = [
        [2, 2, 0],
        [2, 1, 0],
        [4, 2, 8],
    ]

    suma = 0
    sumb = 0

    for i in range(0, len(Arr)):
        suma += Arr[i][i]

    for j in range(0, len(Arr)):
        sumb += Arr[j][len(Arr)-1-j]

    return abs(suma-sumb)


print(diagonalDiff())
