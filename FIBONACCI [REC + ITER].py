import time
def fibrecur(num):
    if num==0:
        return 0
    elif num==1:
        return 1
    else:
        return fibrecur(num-1) + fibrecur(num-2)

if __name__=="__main__":
    initial=time.time()
    print(fibrecur(4))
    print(f"It took {time.time()-initial} ")
