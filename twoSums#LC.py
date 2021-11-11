# understanding the question
# x=[3,7,8,10]
#  if target=10
# output=[0,3] #because 10+3=13


def check():
    target=15
    x=[3,7,8,10]
    for item1 in x:
        for item2 in x:
            if item1+item2==target:  
                if item1==item2:
                    continue
                return x.index(item1),x.index(item2)

if __name__=="__main__":
    returned=check()
    print(returned)
