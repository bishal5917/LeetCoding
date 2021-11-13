
# The function is expected to return a string.
# The function accepts string as parameter.

def logic(my_input):
    converted=my_input.upper()
    replaced=converted.replace(" ","*")
    return replaced
# Do not edit below

# Get the input
my_input = input("Enter the String")

# Print output returned from the logic function
print(logic(my_input))


