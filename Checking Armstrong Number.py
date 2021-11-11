number=int(input("Enter the number you want to check\n"))
power=len(str(number))
numm=number
sum=0

while number>0:
    digit=number%10
    sum += digit**power
    number=number//10           #gives floor value

if numm==sum:
    print(f"{numm} is an armstrong number")

else:
    print(f"{numm} isn't an armstrong number")
