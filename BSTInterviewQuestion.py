class BST:
    def __init__(self, value):
        self.value = value
        self.left = None
        self.right = None

    # O(log(n)) time and O(1) space at best
    # O(n) time and O(1) space at worst
    def insert(self, value):
        currentNode = self
        while True:
            if value < currentNode.value:
                if currentNode.left is None:
                    currentNode.left = BST(value)
                    break
                else:
                    currentNode = currentNode.left
            else:
                if currentNode.right is None:
                    currentNode.right = BST(value)
                    break
                else:
                    currentNode = currentNode.right
        return self

    # O(log(n)) time and O(1) space at best
    # O(n) time and O(1) space at worst
    def contains(self, value):
        currentNode = self
        while currentNode is not None:
            if value < currentNode.value:
                currentNode = currentNode.left
            elif value > currentNode.value:
                currentNode = currentNode.right
            else:
                return True
        return False

    def delete(self, value):
        pass
