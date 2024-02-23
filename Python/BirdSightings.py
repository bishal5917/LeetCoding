
def BirdSightings():
    birds = [1, 4, 4, 4, 5, 3]
    unique = []
    uniques = {}
    for items in birds:
        if items not in uniques:
            unique.append(items)

    for item in unique:
        uniques[item] = 0

    for key in uniques:
        for item in birds:
            if key == item:
                uniques[key] += 1
        # print(key)
        # print(uniques[key])

    keyList = list(uniques.keys())
    keyValues = list(uniques.values())

    position = keyValues.index(max(keyValues))

    return keyList[position]

print(BirdSightings())
