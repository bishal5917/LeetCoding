class MinMaxStack:
    def __init__(self):
        self.minmaxstack = []
        self.stack = []

    def peek(self):
        return self.stack[len(self.stack)-1]

    def pop(self):
        self.minmaxstack.pop()
        return self.stack.pop()

    def push(self, num):
        newMinMax = {'min': num, 'max': num}
        if len(self.minmaxstack):
            lastminmax = self.minmaxstack[len(self.minmaxstack)-1]
            newMinMax['min'] = min(lastminmax['min'], num)
            newMinMax['max'] = max(lastminmax['max'], num)
        self.minmaxstack.append(newMinMax)
        self.stack.append(num)

    def getMin(self):
        return self.minmaxstack[len(self.minmaxstack)-1]['min']

    def getMax(self):
        return self.minmaxstack[len(self.minmaxstack)-1]['max']


if __name__ == "__main__":
    x = MinMaxStack()
    x.push(11)
    x.push(3)
    x.push(5)
    print(x.getMin())
    print(x.getMax())
    print(x.pop())
