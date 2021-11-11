class x:
    class1var1 = "i am in class x"

    def __init__(self):  # class A constructor
        self.var1 = "instance var of class x"
        self.random = "random variable"


class y(x):
    class1var1 = "i am in class y"

    def __init__(self):  # class B constructor
        self.var1 = "instance var of class y"
        # this is called,, so the instance var of a gets called...
        super().__init__()
        # ...even though it was overridden before


a = x()
b = y()

print(b.var1)
print(b.random)
