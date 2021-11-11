import time
initial=time.time()
i=0
while(i<4):
    print("cccttt")
    time.sleep(2)
    i+=1

print("this program was executed in ",time.time()-initial)

initial2=time.time()

for k in range(3):
    print("uuiiuuii")
    time.sleep(3)

print("this program was executed in ",time.time()-initial2)

