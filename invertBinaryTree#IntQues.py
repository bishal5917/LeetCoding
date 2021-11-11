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

def invertTheTree(node):
    if node is None:
        return
    node.left,node.right=node.right,node.left
    invertTheTree(node.left)
    invertTheTree(node.right)
    
if __name__=="__main__":
    rootNode=Node(5)
    rootNode.left=Node(2)
    rootNode.right=Node(20)
    inOrderTraversal(rootNode)
    invertTheTree(rootNode)
    print("After Inverting The Binary Tree")
    inOrderTraversal(rootNode)

    