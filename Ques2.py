# The function is expected to return a string.
# The function accepts string as parameter.

def logic(my_input):
    answer = []
    maxsized = 0
    charToAdd = my_input[0]
    splitted = my_input.split(" ")
    for item in splitted:
        currentLen = len(item)
        if currentLen > maxsized:
            maxsized = currentLen

    for item in splitted:
        while len(item) != maxsized:
            item = charToAdd+item

        answer.append(item)

    final = " ".join(answer)
    return final
    # Do not edit below


    # Get the input
my_input = input()

# Print output returned from the logic function
print(logic(my_input))
