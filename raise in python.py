"""a=input("enter the name of yours")

if a.isnumeric():
    raise Exception("please enter the valid name unless you are a criminal")

print(f"hello {a}")
"""
c=input("enter the name")
try:
    print(a)

except Exception as e:
    if c=="bishal":
        raise ValueError ("This guy is not allowed")


    print("handled successfully ")