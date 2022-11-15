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

    def inOrderTraversal(self, node):
        if node is None:
            return
        self.inOrderTraversal(node.left)
        print(node.value)
        self.inOrderTraversal(node.right)

    def remove(self, value, parentNode=None):
        currentNode = self
        while currentNode is not None:
            if value < currentNode.value:
                parentNode = currentNode
                currentNode = currentNode.left
            elif value > currentNode.value:
                parentNode = currentNode
                currentNode = currentNode.right
            else:
                if currentNode.left is not None and currentNode.right is not None:
                    currentNode.value = currentNode.right.getMinValue()
                    currentNode.right.remove(currentNode.value, currentNode)
                elif parentNode is None:
                    if currentNode.left is not None:
                        currentNode.value = currentNode.left.value
                        currentNode.right = currentNode.left.right
                        currentNode.left = currentNode.left.left
                    elif currentNode.right is not None:
                        currentNode.value = currentNode.right.value
                        currentNode.left = currentNode.right.left
                        currentNode.right = currentNode.right.right
                    else:
                        # This is a single-node tree; do nothing.
                        pass
                elif parentNode.left == currentNode:
                    parentNode.left = (
                        currentNode.left
                        if currentNode.left is not None
                        else currentNode.right
                    )
                elif parentNode.right == currentNode:
                    parentNode.right = (
                        currentNode.left
                        if currentNode.left is not None
                        else currentNode.right
                    )
                    break
        return self

    def getMinValue(self):
        currentNode = self
        while currentNode.left is not None:
            currentNode = currentNode.left
            return currentNode.value


my_bst = BST(10)
my_bst.insert(5)
my_bst.insert(15)
my_bst.insert(2)
my_bst.insert(5)
my_bst.insert(13)
my_bst.insert(22)
my_bst.insert(1)
my_bst.insert(14)
# my_bst.inOrderTraversal(BST(20))
