# array=[1,2,3,2,4,5,6,7,8]
    #    i                j
       
# if target is 2 : ans=[1,3,4,5,6,7,8,2,2]         

def moveElementToEnd(array,target):
    i=0
    j=len(array)-1
    while i<j:
        if array[i]==target and array[j]!=target:
            array[i],array[j]=array[j],array[i]
            j-=1
            i+=1
            
        elif array[i]!=target and array[j]==target:
            i+=1
            
        elif array[i]!=target and array[j]!=target:
            i+=1
            
        elif array[i]==target and array[j]==target:
            j-=1
            i+=1
            
    return array

    
array=[2,1,2,2,4,6,8]
x=moveElementToEnd(array,2)
print(x)

# google interview problem solved by myself , starting to get more confident