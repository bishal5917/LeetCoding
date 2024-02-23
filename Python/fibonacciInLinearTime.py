
# def fibonacciByDictionary(n):
#     dic={1:0,2:1}
#     if n in dic:
#         return dic[n]
#     else:
#         dic[n]=fibonacciByDictionary(n-1)+fibonacciByDictionary(n-2)
#         return dic[n]

# print(fibonacciByDictionary(10))

def fibByIter(n):
    baseList=[0,1]
    count=2  #because i handled 2 cases already i.e first two base cases
    if n==1:
        return 0
    elif n==2:
        return 1
    else:
        while (count!=n):
            nextGuy=baseList[0]+baseList[1]
            baseList[0]=baseList[1]
            baseList[1]=nextGuy
            count+=1
    return baseList[1]

print(fibByIter(10))