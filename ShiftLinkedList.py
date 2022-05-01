from requests import head


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
            print(currNode.data, end=" ")
            currNode = currNode.next

    def ShiftLinkedList(self, shift):
        headTemp = self.head
        lengthOfLL = 1
        # getting the previous tail node
        temp = self.head
        while (temp.next is not None):
            temp = temp.next
            lengthOfLL += 1
        # then here temp is the original tail

        # handling shift for large numbers
        k = shift % lengthOfLL
        # if k==0 then no shifting needed
        if (k != 0):
            posOfTail = lengthOfLL-k
            count = 1
            while (count != posOfTail):
                headTemp = headTemp.next
                count += 1
            # headTemp is new tail node
            newHead = headTemp.next
            # getting the previous tail node
            temp = self.head
            while (temp.next is not None):
                temp = temp.next
            # then here temp is the original tail
            temp.next = self.head
            self.head = newHead
            headTemp.next = None


l = ourlist()
for i in range(0, 6):
    l.insert(i)
l.printing()
print("\n")
l.ShiftLinkedList(2)
l.printing()
