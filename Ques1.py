
# The function is expected to return a string.
# The function accepts string as parameter.

def logic(my_input):
    if my_input[0] == "x" and len(my_input) != 1:
        ans = my_input.replace("x", "z")
    elif my_input == "x":
        ans = my_input.replace("x", "ecks")
    else:
        ans = my_input.replace("x", "cks")

    return ans


# Do not edit below

# Get the input
my_input = input()

# Print output returned from the logic function
print(logic(my_input))
