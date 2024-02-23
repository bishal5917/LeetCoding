class node:
    def __init__(self, data=None, next=None):
        self.data = data
        self.next = next


class linkedList:
    def __init__(self, head=None):
        self.head = head

    def insert(self, data):
        newNode = node(data)
        if (self.head):
            curr = self.head
            while (curr.next):
                curr = curr.next
            curr.next = newNode
        else:
            self.head = newNode

    def display(self):
        temp = self.head
        while(temp):
            print(temp.data)
            temp = temp.next

# This is my own awesome trick
    def delete(self, data):
        if self.head.data == data:
            curr = self.head
            temp = curr
            curr = curr.next
            self.head = curr
            temp.next = None
        else:
            x = self.head
            prev = None
            while(x.data is not data):
                prev = x  # x ko agadi ko thahapaunalai
                x = x.next
            p = x  # x lai p banako tyo xa ma pugepaxi
            prev.next = x.next  # tyo data wala agadiko lai paxadiko sita link garako
            p.next = None  # tyo jun delete garna parni thyo tellai none pardeko


obj = linkedList()
for i in range(4, 8):
    obj.insert(i)
obj.display()
obj.delete(5)
print("after deletion")
obj.display()
