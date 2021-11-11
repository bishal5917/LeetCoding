class Node:
    def __init__(self,data):
        self.left=None
        self.right=None
        self.data=data

def inOrderTraversal(node):
    if node is None:
        return
    inOrderTraversal(node.left)
    print(node.data)
    inOrderTraversal(node.right)

if __name__=="__main__":
    rootNode=Node(5)
    rootNode.left=Node(2)
    rootNode.right=Node(20)
    inOrderTraversal(rootNode)
    