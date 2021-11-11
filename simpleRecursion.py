def show(n):
    print(n)
    if n==0:
        return
    else:
        show(n-1)

show(100)