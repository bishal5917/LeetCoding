
def getLongest(given):
    currentLongest = [0, 1]
    for i in range(0, len(given)):
        odd = palCheck(given, i-1, i+1)
        even = palCheck(given, i-1, i)
        longest = max(even, odd, key=lambda x: x[1]-x[0])
        # Note : key is keyword argument for max()
        currentLongest = max(longest, currentLongest, key=lambda x: x[1]-x[0])
        # maxFind1=max(even,odd) #this doesnot do subtraction(watches the last only)
        # maxFind2=max(even,odd,key=lambda x:x[1]-x[0]) #this do by subtracting

    return given[currentLongest[0]:currentLongest[1]]


def palCheck(given, left, right):
    while (left >= 0 and right < len(given)):
        if (given[left] != given[right]):
            break
        left -= 1
        right += 1
    return [left+1, right]


print(getLongest("abaxyzzyxf"))
