class A:
    def funcc(self):
        print("i am in class A")


class B(A):
    def funcc(self):
        print("i am in class B")


class C(A):
    def funcc(self):
        print("i am in class C")


class D(C, B):            # check this by changing to (B,C) first one gets priority
    pass


a = A()
b = B()
c = C()
d = D()

d.funcc()
