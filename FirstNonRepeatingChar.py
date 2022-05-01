def FirstNonRepeatingCharacter(str):
    wordHash = {}
    for item in str:
        if item in wordHash:
            wordHash[item] += 1
        else:
            wordHash[item] = 1

    # getting the first Non-Repeating one
    for item in wordHash:
        if wordHash[item] == 1:
            return item


str = "abccxxbadddz"
x = FirstNonRepeatingCharacter(str)
print(x)
