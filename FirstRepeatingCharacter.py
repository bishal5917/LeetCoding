
def FirstRepeatingChar():
    str = "kppoopdag"
    hash = {}
    for item in str:
        if hash.get(item):
            return item
        else:
            hash[item] = True


print(FirstRepeatingChar())
