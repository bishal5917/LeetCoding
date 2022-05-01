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
            print(currNode.data)
            currNode = currNode.next


l = ourlist()
for i in range(10, 15):
    l.insert(i)
l.printing()
