inp=[]
p=[]

nums=int(input("Enter total nums you want in list\n"))

for i in range (nums):
    n=int(input(f"Enter number {i}\n"))
    inp.append(n)
    
def pal_gen(n):
    while (str(n) != str(n)[::-1] ):
        n=n+1
    return n

for element in inp:
    x=pal_gen(element)
    p.append(x)
print(p)
