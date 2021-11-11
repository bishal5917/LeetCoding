from abc import ABC,abstractmethod


class shape(ABC):
    @abstractmethod
    def printdetails(self):
        print("i am in class shape and it is the parent class")


class rectangle(shape):
    def __init__(self):
        self.temp=80
        self.speed=2000

    def printdetails(self):
        print("i am in class rectangle and it is the child class")
    
x = rectangle()

print(x.printdetails())
