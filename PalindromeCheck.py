
def PalCheck(given):
    midOne = len(given)//2
    left = midOne-1
    right = midOne+1
    if len(given) % 2 != 0:
        # for odd
        left = midOne-1
        right = midOne+1
        while (left >= 0 and right < len(given)):
            if (given[left] == given[right]):
                left -= 1
                right += 1
            else:
                return False
        return True
    else:
        # for even
        left = midOne-1
        right = midOne
        while (left >= 0 and right < len(given)):
            if (given[left] == given[right]):
                left -= 1
                right += 1
            else:
                return False
        return True


print(PalCheck("racecar"))
print(PalCheck("madam"))
print(PalCheck("poop"))
print(PalCheck("tattarrattat"))
print(PalCheck("abba"))
