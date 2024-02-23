def ValidIPAddresses(string):
    IpAddress = []

    for i in range(1, min(len(string), 4)):
        currentIpParts = ['', '', '', '']
        currentIpParts[0] = string[:i]
        if not isValid(currentIpParts[0]):
            continue

        for j in range(i+1, i+min(len(string)-i, 4)):
            currentIpParts[1] = string[i:j]
            if not isValid(currentIpParts[1]):
                continue

            for k in range(j+1, j+min(len(string)-j, 4)):
                currentIpParts[2] = string[j:k]
                currentIpParts[3] = string[k:]
                if isValid(currentIpParts[2]) and isValid(currentIpParts[3]):
                    IpAddress.append('.'.join(currentIpParts))

    return IpAddress


# checking if that value is less than 256 and greater than 0
# Thats the condition for making valid IP Addresses
def isValid(string):
    intconverted = int(string)
    if intconverted >= 0 and intconverted < 256:
        return True
    return False


if __name__ == "__main__":
    address = "1921680"
    print(ValidIPAddresses(address))
