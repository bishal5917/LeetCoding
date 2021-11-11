numA=int(input("Enter the first number "))
numB=int(input("Enter the second number "))

minimum=min(numA,numB)

for i in range(1,minimum+1):
    if (numA%i==0 and numB%i==0):
        print(i)

print(f"hcf is {i}")
