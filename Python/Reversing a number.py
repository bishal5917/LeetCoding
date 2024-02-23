"""
#This is our Pythonic way
num=int(input("ENter the num"))

x=str(num)

print(len(x))
"""

#Lets do in oldskool way for practise
n=4636
count=0
list=[]
while (n!=0):
    x=(n/10-n//10)*10
    p=round(x)
    count+=1
    n=n//10
    list.append(p)

print(count)
print(list)