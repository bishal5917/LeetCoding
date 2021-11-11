class node:
    def __init__(self, data, next=None, head=None):
        self.data = data
        self.next = next
        self.head = head


class CreateAndReverse:
    def __init__(self, head=None):
        self.head = head

    def createList(self, data):
        newnode = node(data)
        if self.head is None:
            self.head = newnode
        else:
            self.curr = self.head
            while self.curr.next:
                self.curr = self.curr.next
            self.curr.next = newnode

    def traversal(self):
        self.temp = self.head
        while self.temp is not None:
            print(self.temp.data)
            self.temp = self.temp.next

    def reverse(self):
        self.prev = None
        self.curr = self.head
        while self.curr is not None:
            self.nextOne = self.curr.next
            self.curr.next = self.prev
            self.prev = self.curr
            self.curr = self.nextOne

        self.head = self.prev


if __name__ == "__main__":
    x = CreateAndReverse()
    x.createList(31)
    x.createList(21)
    x.createList(11)
    x.createList(41)
    x.createList(111)
    x.traversal()
    x.reverse()
    print("After reversing")
    x.traversal()
