
def SmallestDiff():
    A = [1, 5, 10, 20, 28, 3]
    B = [26, 134, 135, 15, 17]

    A.sort()
    B.sort()
    
    smallest=float("inf")
    current=float("inf")
    
    i=0  #pointer for A
    j=0  #pointer for B
    
    while (i<len(A) and j<len(B)):
        first=A[i]
        second=B[j]
        
        if first<second:
            current=second-first
            i+=1
        elif second<first:
            current=first-second
            j+=1
        else:
            return [first,second]
        if smallest>current:
            smallest=current
            smallestPair=[first,second]
            
    return smallest,smallestPair

print(SmallestDiff())
