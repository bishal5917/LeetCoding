
def pal_check():
    n=int(input("Enter the number you want the next palindrome of"))

    while (str(n) != str(n)[::-1]):
        n=n+1
    print(n)

pal_check()