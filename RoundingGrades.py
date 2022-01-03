def roundGrades():
    initialGrades = [73, 67, 38, 43]
    nextMultiple = []

    for items in initialGrades:
        while items % 5 != 0:
            items += 1
        nextMultiple.append(items)

    # pointerBeforeRounded
    i = 0
    # pointerAfterRounded
    j = 0

    afterRounded = []

    while(i < len(initialGrades) and j < len(nextMultiple)):
        if (abs(initialGrades[i]-nextMultiple[j]) < 3):
            afterRounded.append(nextMultiple[j])
            i += 1
            j += 1
        else:
            afterRounded.append(initialGrades[i])
            i += 1
            j += 1

    return afterRounded

print(roundGrades())
