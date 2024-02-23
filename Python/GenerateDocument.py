def GenerateDocument(chars, doc):
    #checking if we can generate doc from given characters or not 
    charHash = {}
    for item in chars:
        if item in charHash:
            charHash[item] += 1
        else:
            charHash[item] = 1

    for item in doc:
        if item in charHash:
            if charHash[item] == 0:
                return False
            else:
                charHash[item] -= 1
        if item not in charHash:
            return False

    return True


if __name__ == "__main__":
    characters = "Bste!hetsi ogEAxpelrt  "
    document = "AlgoExpert is the Best!"
    x = GenerateDocument(characters, document)
    print(x)
