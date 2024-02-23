
BinaryList = []
octal = []
HDecimal = []


def Binary():
    global n
    while (n != 0):
        rem = n % 2
        n = n//2  # Taking the Floor value for next division
        BinaryList.append(rem)

    print(f"Binary is {BinaryList[::-1]}")  # Reversing the list


def Octal():
    global n
    while (n != 0):
        rem = n % 8
        n = n//8
        octal.append(rem)

    print(f"Octal is {octal[::-1]}")


def HexaD():
    global n
    while (n != 0):
        rem = n % 16
        n = n//16
        HDecimal.append(rem)

    print(f"HexaDecimal is {HDecimal[::-1]}")


if __name__ == "__main__":
    while True:
        n = int(input("Enter the decimal number\n"))
        print("-----Press b to convert it into Binary-----")
        print("-----Press o if you want to convert it into Octal-----")
        print("-----Print h to convert it into HexaDecimal-----")
        print("-----Press e to QUIT")
        ch = input()
        if ch == "b":
            Binary()
        elif ch == "o":
            Octal()
        elif ch == "h":
            HexaD()
        elif ch == "e":
            break
        else:
            print(" ERROR : Invalid Input !!! ")
