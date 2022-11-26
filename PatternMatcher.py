def PatternMatcher(pattern, str):
    patternarr = []
    for item in pattern:
        patternarr.append(item)

    # getting first index of y
    for i in range(0, len(pattern)):
        if pattern[i] == "y":
            firstYIdx = i
            break
    
    


if __name__ == "__main__":
    pattern = "xxyxxy"
    str = "gogopowerrangergogopowerranger"
    print(PatternMatcher(pattern, str))
