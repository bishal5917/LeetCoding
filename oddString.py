def oddString(words):
    diff = []
    diffTracker = []

    for item in words:
        i, j = 0, 1
        while i < len(item) - 1 and j < len(item):
            diff.append(ord(item[j]) - ord(item[i]))
            i += 1
            j += 1
        diffTracker.append(diff)
        diff = []

    
    for i in range(0, len(diffTracker) - 2):
        if (
            diffTracker[i] == diffTracker[i + 1]
            and diffTracker[i] != diffTracker[i + 2]
        ):
            return words[i + 2]
        if (
            diffTracker[i] == diffTracker[i + 2]
            and diffTracker[i] != diffTracker[i + 1]
        ):
            return words[i + 1]
        if (
            diffTracker[i + 1] == diffTracker[i + 2]
            and diffTracker[i] != diffTracker[i + 1]
        ):
            return words[i]


if __name__ == "__main__":
    words = ["adc", "wzy", "abc"]
    print(oddString(words))
