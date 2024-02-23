
def LD():
    str1 = "passed"
    str2 = "past"
    arr = [[x for x in range(len(str2)+1)] for y in range(len(str1)+1)]
    for i in range(1, len(str1)+1):
        arr[i][0] = arr[i-1][0]+1
    for i in range(1, len(str1)+1):  # i=row
        for j in range(1, len(str2)+1):  # j=column
            if str1[i-1] == str2[j-1]:
                arr[i][j] = arr[i-1][j-1]
            else:
                arr[i][j] = 1+min(arr[i-1][j-1], arr[i-1][j], arr[i][j-1])
    return arr[-1][-1]

print(LD())
