# The function is expected to return an integer.
# The function accepts string as parameter.

def logic(my_input):
    happynumcount = 0
    for i in range(0, len(my_input)):
        if len(my_input) == 1:
            break
        if i > 1 and i < len(my_input)-2:
            if my_input[i-1] != my_input[i+1]:
                happynumcount += 1
        if i == 0:
            if my_input[0] == my_input[1]:
                happynumcount += 1
        if i == len(my_input)-1:
            if my_input[len(my_input)-2] == my_input[len(my_input)-2]:
                happynumcount += 1

    return happynumcount

    # Do not edit below
    # Get the input
my_input = input()

# Print output returned from the logic function
print(logic(my_input))
