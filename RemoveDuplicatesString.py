
def removeDuplicatesString(s):
    itemHash=[]

    for item in s:
        if item not in itemHash:
            itemHash.append(item)
    
    return "".join(itemHash)

if __name__=="__main__":
    s = "bcabc"
    print(removeDuplicatesString(s))

