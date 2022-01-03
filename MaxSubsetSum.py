
def MaxSubSetSum():
    arr=[7,10,12,7,9,14]
    second=arr[0]
    first=max(arr[0],arr[1])
    for i in range(2,len(arr)):
        current=max(first,second+arr[i])
        second=first
        first=current
    return first

print(MaxSubSetSum())
    
    