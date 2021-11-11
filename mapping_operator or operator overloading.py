# THE PROCESS OF BEING ABLE TO USE OPEARTORS WITH USER DEFINED DATA TYPES OR THE PROCESS OF ADDING
# SPECIAL MEANING TO THE OPERATORS IS CALLED OPERATOR OVERLOADING

class A:
    def __init__(self, name, salary):
        self.name = name
        self.salary = salary
        print("called A cons")

    def __add__(self, other):
        return self.salary+other.salary

    # def __floordiv__(self, other):
        # return self.salary+other.salary


a = A("pinnell", 6000)
b = A("codesum", 1000)
print(a+b)

# here addition operator is overloaded as it is made able to be used with...
# ...user defined data types
