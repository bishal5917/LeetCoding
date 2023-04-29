def ransomNotes(ransomNote, magazine):
    ransomHash = {}
    magazineHash = {}

    for item in ransomNote:
        if item not in ransomHash:
            ransomHash[item] = 1
        else:
            ransomHash[item] += 1

    for item in magazine:
        if item not in magazineHash:
            magazineHash[item] = 1
        else:
            magazineHash[item] += 1

    for item in ransomHash:
        usedInRansom = ransomHash[item]
        if item not in magazineHash:
            return False
        availableInMagazine = magazineHash[item]
        if usedInRansom > availableInMagazine:
            return False

    return True


if __name__ == "__main__":
    ransomNote = "aa"
    magazine = "aab"
    print(ransomNotes(ransomNote, magazine))
