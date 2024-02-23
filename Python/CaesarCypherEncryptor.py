def CaesarCypherEncryptor(str, k):
    # ord gives the unicode values a=97 z=122
    slc = []  # shifted letter codes
    k = k % 26  # for handling large keys
    for item in str:
        nlc = ord(item)+k  # nlc=new letter codes
        slc.append(nlc)

    for item in slc:
        if item <= 122:
            print(chr(item), end="")
        else:
            print(chr(96+item % 122), end="")


if __name__ == "__main__":
    str = "xyz"
    key = 2
    CaesarCypherEncryptor(str, key)

# We can also do this question without using the unicode values .
# we can do by setting ordered value to all alphabets in order
# for eg : a=1,b=2,c=3 ...... z=26 and do shifting process as above !!!
