def dec1(func):
    def nowexec():
        print("executing now")
        func()
        print("executed")
    nowexec()

@dec1
def bluep():
    print("aot is the greatest anime in the world")
bluep()