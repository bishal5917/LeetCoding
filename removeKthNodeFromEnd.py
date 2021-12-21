class node:
    def __init__(self, value=None, next=None):
        self.value = value
        self.next = next


class linkedList:
    def __init__(self, head=None):
        self.head = head

    def insert(self, data):
        newNode = node(data)
        if (self.head):
            current = self.head
            while (current.next):
                current = current.next
            current.next = newNode
        else:
            self.head = newNode

    def traverse(self):
        curr = self.head
        while curr is not None:
            print(curr.value)
            curr = curr.next
            
    def deleteNthNodeFromEnd(self,n):
        firstPtr=self.head
        for i in range(1,n):
            front=front.next
        secondPtr=front
        while secondPtr.next is not None:
            firstPtr=firstPtr.next
            secondPtr=secondPtr.next
        
        
            
obj = linkedList()
for i in range(4, 14):
    obj.insert(i)
obj.traverse()
