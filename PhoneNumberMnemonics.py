# Time and Space Complexity O(4^n*n) No any better way to do this
def PNM(nemo, num):
    currentPnemonics = ["0"]*len(num)
    result = []
    phoneNumberPnemonicsHelper(0, nemo, num, currentPnemonics, result)
    return result


def phoneNumberPnemonicsHelper(idx, nemo, num, currentPnemonics, result):
    if idx == len(num):
        result.append("".join(currentPnemonics))  # This takes O(n) time
    else:
        digit = num[idx]
        letters = nemo[digit]
        for letter in letters:
            currentPnemonics[idx] = letter
            phoneNumberPnemonicsHelper(
                idx+1, nemo, num, currentPnemonics, result)


if __name__ == "__main__":
    Pnemonics = {
        "0": ["0"],
        "1": ["1"],
        "2": ["a", "b", "c"],
        "3": ["d", "e", "f"],
        "4": ["g", "h", "i"],
        "5": ["j", "k", "l"],
        "6": ["m", "n", "o"],
        "7": ["p", "q", "r", "s"],
        "8": ["t", "u", "v"],
        "9": ["w", "x", "y", "z"],
    }
    num = "1905"
    print(PNM(Pnemonics, num))
