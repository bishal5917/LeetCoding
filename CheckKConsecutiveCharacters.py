# Check if there are 3 consecutive characters in a string

def CheckThreeConsecutive(str):
    for i in range(0, len(str)-2):
        if str[i] == str[i+1] and str[i] == str[i+2]:
            return True


str1 = "1100111"
print(CheckThreeConsecutive(str1))

# Check if there are n consecutive characters in a string


def CheckKConsecutive(str, k):
    for i in range(0, len(str)-k+1):
        count = 0
        for j in range(i, i+k-1):
            if str[i] == str[j]:
                count += 1
    if count == k:
        return True
    else:
        return False


str2 = "01111000"
print(CheckKConsecutive(str2, 4))
