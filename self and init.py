class Scout:

    def printdetails(self):
        return f"name is {self.name} and age is {self.age}"


levi=Scout()
hange=Scout()

levi.name="captain levi"
levi.age=35

hange.name="hange zoe"
hange.age=30

print(levi.printdetails())
print(hange.printdetails())


#this is use of self

