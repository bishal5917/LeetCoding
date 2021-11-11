def searchbox():
    book=" harry larry barry pinnell bishal mark joma steve elon coder"
    import time
    time.sleep(3)

    while True:
        name=(yield)
        if name in book:
            print("name is present")

        else:
            print("name not found")

search=searchbox()
next(search)
x=input("enter the name ")
search.send(x)
input("press any key ")
search.close()
