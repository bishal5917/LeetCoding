
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
            print(curr.value,end=" ")
            curr = curr.next

    def deleteNthNodeFromEnd(self, n):
        firstPtr = self.head
        secondPtr = self.head
        # count = 1
        # while count <= n:
        #     secondPtr = secondPtr.next
        #     count += 1
        for i in range(0, n):
            secondPtr = secondPtr.next
        if secondPtr is None:
            self.head.value = self.head.next.value
            self.head.next = self.head.next.next
            return
        while secondPtr.next is not None:
            firstPtr = firstPtr.next
            secondPtr = secondPtr.next
        firstPtr.next = firstPtr.next.next


obj = linkedList()
for i in range(4, 14):
    obj.insert(i)
print("Before Deletion")
obj.traverse()
print("\n")
obj.deleteNthNodeFromEnd(4)
print("After Deletion")
obj.traverse()

