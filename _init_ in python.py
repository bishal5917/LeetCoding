class Scout:

    def _init_(self,xname,xpost,xrole):
        self.name=xname
        self.post=xpost
        self.role=xrole

    def printdetails(self):
        return f"name is {self.name} and post is {self.post} and role is {self.role}"

levi=Scout("Levi ackerman","captain","beast killer")

print(levi.name)
print(levi.post)
print(levi.role)



