class node:
    def __init__(self, data=None, next=None):
        self.data = data
        self.next = next


class ourlist:
    def __init__(self, head=None):
        self.head = head

    def insert(self, data):
        newNode = node(data)
        if self.head:
            currNode = self.head
            while currNode.next:
                currNode = currNode.next
            currNode.next = newNode
        else:
            self.head = newNode

    def BubbleSortLL(self):
        iters = self.head
        while iters:
            i = self.head
            while i.next:
                if i.data > i.next.data:
                    i.data, i.next.data = i.next.data, i.data

                i = i.next
            iters = iters.next

    def printing(self):
        currNode = self.head
        while currNode:
            print(currNode.data, end=" ")
            currNode = currNode.next


l = ourlist()
l.insert(5)
l.insert(1)
l.insert(3)
l.insert(2)
l.insert(4)
l.printing()
l.BubbleSortLL()
print("After Bubble Sorting")
l.printing()
