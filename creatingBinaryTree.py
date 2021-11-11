class Node:
    def __init__(self, data=None, left=None, right=None):
        self.left = left
        self.right = right
        self.data = data

    def insert(self, data):
        new = Node(data)
        if self.data:
            if data < self.data:
                if self.left is None:
                    self.left = new
                else:
                    self.left.insert(data)
            elif data > self.data:
                if self.right is None:
                    self.right = new
                else:
                    self.right.insert(data)
        else:
            self.data = data

    def PrintTree(self):
        if self.left:
            self.left.PrintTree()
        print(self.data)
        if self.right:
            self.right.PrintTree()


obj = Node()
obj.insert(14)
obj.insert(35)
obj.insert(31)
obj.insert(10)
obj.insert(19)
obj.PrintTree()
