"""
Original problem: "There are N cards in a row and they can be face up or face down. A turn consists of
 taking two adjacent cards where the left one is face up and the right one can be face up or face down 
 and flipping them both. Show that this process terminates.
 """
x = []


def cardinput():
    for i in range(N):
        card = int(input())
        x.append(card)
        print(x)


def procedure():
    for j in range(N-1):
        if x[j] == 1 and x[j+1] == 0:
            x[j] = 0
            x[j+1] = 1
        elif x[j] == 1 and x[j+1] == 1:
            x[j] = 0
            x[j+1] = 0
        else:
            pass


if __name__ == "__main__":
    N = int(input("Enter the number of cards you have\n"))
    print("Enter the status of your cards simultaneously")
    print(" -----NOTE THAT-----\n 1 = Face Down Card\n 0 = Face Up Card")
    cardinput()
    procedure()
    print("status after procedure = ",x)
