import inspect

class employee:
    def __init__(self, name, roll):
        self.name = name
        self.roll = roll

x1=employee("hackathon",22812)
"""
print(type(x1))

print(dir(x1))   #this is for getting members

##in this way we can find the details of the object which is known as object introspection
 """
#another method by using inspect module
print(inspect.getmembers(x1))