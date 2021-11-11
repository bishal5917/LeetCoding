
class node:
    def __init__(self,data,left=None,right=None):
        self.data=data
        self.left=left
        self.right=right

def traversalinOrder(rootN):
    if rootN is None:
        return
    traversalinOrder(rootN.left)
    print(rootN.data)
    traversalinOrder(rootN.right)

def branchsums(rootb):
    sumslist=[]
    recursiveBsums(rootb,0,sumslist)
    return sumslist

def recursiveBsums(rootb,currentrunningsum,sumslist):
    if rootb is None:
        return
    finalSum=currentrunningsum+rootb.data
    if rootb.left is None and rootb.right is None:
        sumslist.append(finalSum)
        return
    recursiveBsums(rootb.left,finalSum,sumslist)
    recursiveBsums(rootb.right,finalSum,sumslist)

if __name__=="__main__":
    root=node(7)
    root.left=node(10)
    root.right=node(56)
    traversalinOrder(root)
    print("The branch sums is ")
    x=branchsums(root)
    print(x)