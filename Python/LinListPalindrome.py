# Note : This Palindrome Checking only works for the even liked list
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
            print(currNode.data, end="")
            currNode = currNode.next

    def ReverseHalf(self):
        slowPtr = self.head
        fastPtr = self.head
        while fastPtr.next.next is not None:
            slowPtr = slowPtr.next
            fastPtr = fastPtr.next.next
        # swapping
        slowPtr.next.data, fastPtr.next.data = fastPtr.next.data, slowPtr.next.data

        return slowPtr.next

    def CheckHalves(self):
        # Now checking the reversed half to the original one
        getSecond = self.ReverseHalf()
        getFirst = self.head
        while getSecond:
            if getFirst.data != getSecond.data:
                return False
            getFirst = getFirst.next
            getSecond = getSecond.next
        return True


l = ourlist()
l.insert(1)
l.insert(3)
l.insert(2)
l.insert(2)
l.insert(3)
l.insert(1)
l.printing()
print(l.CheckHalves())
l.printing()
