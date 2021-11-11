class employee:
    def __init__(self, name, roll):
        self.name = name
        self.roll = roll

    @property
    def emailadd(self):
        if self.name==None or self.roll==None:
            print("email isnot set,please set it using setter.....")
        return f"{self.name}.{self.roll}@gmail.com"

    @emailadd.deleter
    def emailadd(self):
        self.name=None
        self.roll=None

    @emailadd.setter
    def emailadd(self,string):
        print("setting..............")
        names=string.split("@")[0]
        self.name=string.split(".")[0]
        self.roll=string.split(".")[1]

em = employee("bishal", 12)

em.name = "hacker"
# if property decorator is used on function printdeatils then it<<<<<<
print(em.emailadd)
# >>>>>>isnot necessary to run printdetails as function
em.emailadd="up.591.7@gmail.com"
print(em.name)
print(em.roll)
del em.emailadd
print(em.emailadd)

