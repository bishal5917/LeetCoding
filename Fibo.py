def fibonacci(n):
    first=0
    second=1
    count=0
    if n==1:
        print(first)
    else:
        while (count<n):
            print(first,end=" ")
            another=first+second
            first=second
            second=another
            count+=1
            
fibonacci(2)