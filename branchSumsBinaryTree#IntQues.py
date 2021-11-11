class Tree:
    def __init__(self, data=None, left=None, right=None):
        self.data = data
        self.right = right
        self.left = left

    def create(self, data):
        if self.data:
            if data < self.data:
                if self.left is None:
                    self.left = Tree(data)
                else:
                    self.left.create(data)
            if data > self.data:
                if self.right is None:
                    self.right = Tree(data)
                else:
                    self.right.create(data)
        else:
            self.data = data

    def print(self):
        if self.left:
            self.left.print()
        print(self.data)
        if self.right:
            self.right.print()


if __name__ == "__main__":
    obj = Tree()
    obj.create(4)
    obj.create(3)
    obj.create(31)
    obj.create(10)
    obj.create(29)
    obj.print()
