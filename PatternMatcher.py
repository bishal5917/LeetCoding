def PatternMatcher(pattern, str):
    patternarr = []
    for item in pattern:
        patternarr.append(item)

    return patternarr


if __name__ == "__main__":
    pattern = "xxyxxy"
    str = "gogopowerrangergogopowerranger"
    print(PatternMatcher(pattern, str))
