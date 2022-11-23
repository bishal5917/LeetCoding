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
for i in range(10, 15):
    l.insert(i)
l.printing()
