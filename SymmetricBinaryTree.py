
class Node:
    def __init__(self, data):
        self.left = None
        self.right = None
        self.data = data


def are_symmetric(root1, root2):
    if root1 is None and root2 is None:
        return True
    elif ((root1 is None) != (root2 is None) or root1 != root2):
        return False
    else:
        return are_symmetric(root1.left, root2.right) and are_symmetric(root1.right, root2.left)


def is_symmetric(root):
    if root is None:
        return True
    return are_symmetric(root.left, root.right)


if __name__ == "__main__":
    rootNode = Node(2)
    rootNode.left = Node(2)
    rootNode.right = Node(2)
    print(is_symmetric(rootNode))
