def gen(n):
    for i in range(n):
        yield i

x=gen(6)

print(x)

print(x.__next__())
print(x.__next__())
print(x.__next__())
print(x.__next__())

for i in x:
    print(i)
