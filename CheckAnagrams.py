
def CheckAnagrams(str1, str2):
    if len(str1) != len(str2):
        return False
    charDictA = {}
    charDictB = {}

    for item in str1:
        if item in charDictA:
            charDictA[item] += 1
        else:
            charDictA[item] = 1

    for item in str2:
        if item in charDictB:
            charDictB[item] += 1
        else:
            charDictB[item] = 1

    for key in charDictA:
        if key not in charDictB or charDictA[key] != charDictB[key]:
            return False
        else:
            return True


str1 = "bored"
str2 = "robed"
print(CheckAnagrams(str1, str2))
