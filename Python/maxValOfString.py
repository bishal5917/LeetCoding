def maxValOfString(strs):
    val = 0
    for item in strs:
        if item.isdigit():
            val = max(val, int(item))
        else:
            val = max(val, len(item))

    return val


if __name__ == "__main__":
    strs = ["alic3", "bob", "3", "4", "00000"]
    print(maxValOfString(strs))
