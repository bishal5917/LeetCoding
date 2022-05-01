def ValidateSubsequence(array, sequence):
    i = 0
    j = 0
    count = 0
    while (j < len(sequence)) and (i < len(array)):
        if array[i] == sequence[j]:
            i += 1
            j += 1
            count += 1
        else:
            i += 1

    return count == len(sequence)


if __name__ == "__main__":
    array = [5, 1, 22, 25, 6, -1, 8, 10]
    sequence = [1, 6, -1, 10]
    x = ValidateSubsequence(array, sequence)
    print(x)
