class node:
    def __init__(self, data=None, next=None):
        self.data = data
        self.next = next


class ourlist:
    def __init__(self, head=None):
        self.head = head

    def insert(self, data):
        newNode = node(data)
        if (self.head):
            currNode = self.head
            while(currNode.next):
                currNode = currNode.next
            currNode.next = newNode
        else:
            self.head = newNode

    def printing(self):
        currNode = self.head
        while(currNode):
            print(currNode.data, end=" ")
            currNode = currNode.next

    def RemoveDuplicates(self):
        currentNode = self.head
        while currentNode is not None:
            nextNode = currentNode.next
            while nextNode is not None and nextNode.data == currentNode.data:
                nextNode = nextNode.next

            currentNode.next = nextNode
            currentNode = nextNode


l = ourlist()
l.insert(1)
l.insert(1)
l.insert(3)
l.insert(4)
l.insert(4)
l.insert(4)
l.insert(5)
l.insert(6)
l.insert(6)
l.printing()
l.RemoveDuplicates()
print("\n")
l.printing()
