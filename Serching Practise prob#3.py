to_search=["This is a search program","Python is language not snake","python makes robot but its a snake"]

search=(input("Enter the string to search\n"))
list=[]

for element in to_search:
    element.split(",")
    # print(element)
    x=element.split()
    list.append(x)

    if search in x:
        print("Found")
        print(x)
        continue
    else:
        print("No Further Results")
        break

