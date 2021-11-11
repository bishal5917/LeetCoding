table=[]

number=int(input("Enter the number you want the multiplication table of : "))
rg=int(input("Enter how many multiples do you want : "))

for i in range(1,rg+1):
    x=number*i
    table.append(x)

print(table)