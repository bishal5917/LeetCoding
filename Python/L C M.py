numA=int(input("Enter the first number"))
numB=int(input("Enter the second number"))

mx=max(numA,numB)

while True:
    if(mx%numA==0 and mx%numB==0):
        break;

    mx=mx+1

print(f"LCM is {mx}")
