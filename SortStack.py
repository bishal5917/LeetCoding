def SortStack(stack):
    if len(stack)==0:
        return stack
    top=stack.pop()
    SortStack(stack)
    insertInOrder(stack,top)
    return stack

def insertInOrder(stack,val):
    if len(stack)==0 or stack[len(stack)-1]<=val:
        stack.append(val)
        return
    top=stack.pop()
    insertInOrder(stack,val)
    stack.append(top)
    
if __name__=="__main__":
    stack=[5,6,3,4,1]
    print(SortStack(stack))
    