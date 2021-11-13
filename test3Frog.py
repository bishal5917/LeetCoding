# The function is expected to return a string.
# The function accepts string as parameter.
# ***********************************TO DEBUG*****************************************
def logic(my_input):
    # Write your code here and remove pass statement
    # Don't print anything. Just return the intended output
    # You can create other functions and call from here
    i=0
    j=1
    ansList=[]
    while i<len(my_input) and j<len(my_input):
        if my_input[i]==my_input[j]:
            i+=2
            j+=2
        if my_input[i]!=my_input[j]:
            ansList.append(max(my_input[i],my_input[j]))
            i+=2
            j+=2
    if ansList.len()==0:
        return "total carnage"
    else:
        return ansList
        
    
# Do not edit below

# Get the input
my_input = input("Enter")

# Print output returned from the logic function
print(logic(my_input))


