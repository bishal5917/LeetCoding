def funargs(normal,*args,**kwargs):
    for item in args:
        print(item)
    for key,value in kwargs.items:
        print(f"{key} is {value})

kw={"ram":"helper","shyam":"worker"}
har=["thgh","jjhhs"]
normal=665
print(normal)
funargs(normal,*har,**kw)