class memory:
    capacity=500
    ##temp=35

    def info(self):
        return f"the memory has {self.capacity} and is running at {self.temp} degree celsius"

class cpu(memory):
    speed=4
    temp=50

    def info(self):
        return f"the cpu is running at {self.temp} degree celsius"

class gpu(cpu):
    speed=2
    ##temp=70

    def info(self):
        return f"the gpu is running at {self.temp} degree celsius"

m=memory()
c=cpu()
g=gpu()

print(g.speed)
x=g.info()
print(x)
print(g.temp)