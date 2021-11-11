import time
from functools import lru_cache

@lru_cache(maxsize=5)
def func1(n):
    time.sleep(n)
    return n

if __name__=='__main__':
    print("inside the main function")
    func1(1)
    func1(3)
    func1(1)
    func1(1)
    func1(1)
    print("called after delay")
    func1(3)
    print("finished the operation")
