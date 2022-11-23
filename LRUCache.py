class node:
    def __init__(self, data=None, next=None, prev=None):
        self.data = data
        self.next = next
        self.prev = prev


class DoublyLinkedList:
    def __init__(self, head=None, tail=None):
        self.head = head
        self.tail = tail

    def insert(self, data):
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
l.insert(5)
l.insert(4)
l.insert(3)
l.printing()
# l.removeHead()
# l.removeTail()
l.printing()
