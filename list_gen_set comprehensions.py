"""
x=[]
for i in range(20):
    if i%3==0:
        x.append(i)
print(x)
"""
# list comprehension
list1 = [i for i in range(20) if i % 3 == 0]
print(list1)

# dictionary comprehension
dict1 = {i: f"item{i}" for i in range(5)}
print(dict1)

# inversing dictionary
dictinv = {value: key for key, value in dict1.items()}
print(dictinv)

# generator comprehension
gen = (i for i in range(10) if i % 3 == 0)
print(gen)
print(gen.__next__())
print(gen.__next__())
print(gen.__next__())
# and so on
