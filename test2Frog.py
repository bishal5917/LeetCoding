# The function is expected to return a string.
# The function accepts string as parameter.

def logic(my_input):
    # Write your code here and remove pass statement
    # Don't print anything. Just return the intended output
    # You can create other functions and call from here
    vowels="aeiou"
    repeated=[]
    count=0
    for item in vowels:
        for element in my_input:
            if item==element:
                if element not in repeated:
                    if count!=0:
                        repeated.append(count)
                    repeated.append(element)
                if element in repeated:
                    count+=1
                    
    listToStr = ' '.join(map(str, repeated))
    return listToStr

# Do not edit below

# Get the input
my_input = input("Enter the string to check")

# Print output returned from the logic function
print(logic(my_input))
