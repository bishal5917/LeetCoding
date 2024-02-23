
def searchInSortedMatrix(array,target):
    row=0
    column=len(array[0])-1
    while row<len(array) and column>=0:
        if array[row][column]>target:
            column-=1
        elif array[row][column]<target:
            row+=1
        else:
            return (row,column)
        
    return [-1,-1]

array=[
    [1,4,7,12,15,1000],
    [2,5,19,31,32,1001],
]
x=searchInSortedMatrix(array,32)
print(x)
