# WAP to return the length of a longest palindrome that we can make from a given string

def LongestPalindrome(str):
    dict = {}
    longestLen = 0
    for item in str:
        if item in dict:
            dict[item] += 1
        else:
            dict[item] = 1

    for elems in dict.values():
        if elems % 2 == 0:
            longestLen += elems
        else:
            longestLen += elems-1

    if longestLen < len(str):
        return longestLen+1
    else:
        return longestLen

str1 = "abbaba"
str2 = "abbaaa"
str3 = "abbabab"
str4 = "abdccdceeebebc"
print(LongestPalindrome(str1))
print(LongestPalindrome(str2))
print(LongestPalindrome(str3))
print(LongestPalindrome(str4))
