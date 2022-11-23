class node:
    def __init__(self, data=None, next=None, prev=None):
        self.data = data
        self.next = next
        self.prev = prev


class DoublyLinkedList:
    def __init__(self, head=None, tail=None):
        self.head = head
        self.tail = tail

    def insertAtEnd(self, data):
        newNode = node(data)

        if self.head is None:
            self.head = newNode
            self.tail = newNode
            return

        current = self.head
        # going to last
        while current.next is not None:
            current = current.next

        newNode.prev = current
        current.next = newNode
        self.tail = newNode

    def insertAtBeginning(self, data):
        newNode = node(data)

        if self.head is None:
            self.head = newNode
            self.tail = newNode
            return

        currhead = self.head
        newNode.next = currhead
        currhead.prev = newNode
        newNode.prev = None
        self.head = newNode

    def removeHead(self):
        # self.head=self.head.next
        x = self.head
        y = x.next
        self.head = y
        x.next = None

    def removeTail(self):
        x = self.head
        while x.next is not None:
            x = x.next
        x.prev.next = None
        x.next = None

    def makeGivenNodeNewHead(self, val):
        temp = self.head
        while temp.data != val:
            temp = temp.next
        left = temp.prev
        right = temp.next
        temp.next = self.head
        left.next = right
        self.head = temp

    def printing(self):
        if self.head is None:
            print("---<Empty>---")

        statement = ""
        current = self.head
        while current:
            statement += str(current.data)
            current = current.next
            if current:
                statement += " ---> "

        print(statement + "")


l = DoublyLinkedList()
l.insertAtEnd(5)
l.insertAtEnd(4)
l.insertAtEnd(3)
l.insertAtBeginning(2)
l.insertAtBeginning(1)
l.printing()
l.makeGivenNodeNewHead(3)
# l.removeHead()
# l.removeTail()
l.printing()
