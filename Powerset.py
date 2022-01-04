
def PowerSet():
    array=[1,2,3,4]
    subsets=[[]]
    for item in array:
        for i in range(len(subsets)):
            currentsubset=subsets[i]
            subsets.append(currentsubset+[item])
    
    return subsets

x=PowerSet()
print(x)
