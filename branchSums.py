class Tree:
    def __init__(self, data=None, left=None, right=None):
        self.data = data
        self.left = left
        self.right = right


def branchSums(root):
    sumsList = []
    recursiveSums(root, 0, sumsList)
    return sumsList


def recursiveSums(root, currentSum, sumsList):
    if root is None:
        return
    finalSum = currentSum+root.data
    if root.left is None and root.right is None:
        sumsList.append(finalSum)
        return
    recursiveSums(root.left, finalSum, sumsList)
    recursiveSums(root.right, finalSum, sumsList)


if __name__ == "__main__":
    root = Tree(21)
    root.left = Tree(2)
    root.right = Tree(3)
    x=branchSums(root)
    print(x)
