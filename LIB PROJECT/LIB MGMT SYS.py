mybooks = ["c++", "python", "software", "graphics"]
st_names = []
import json


def returnbook():
    name_r = input("enter your full name")
    # st_names.remove(name_r)
    returned = input("Name the book you are about to return")
    mybooks.append(returned)
    file = open("books file", "w")
    for element in mybooks:
        file.write(element + "\n")
    print(f"{returned} returned successfully by {name_r}")
    print(f" we have {mybooks}")


def borrowbook():
    name_b = input("enter your full name")
    if name_b not in st_names:
        st_names.append(name_b)
    to_borrow = input("Enter the name of book you want to borrow")

    a_file = open("books file.txt", "w")
                  ////////work here /////////////
    # print(f"{to_borrow} borrowed successfully by {name_b}")
    # print(f" we have {mybooks}")


if __name__ == "__main__":
    while True:
        print("----------------------WELCOME TO PINNELL'S LIBRARY------------------------")
        print(f" we have {mybooks}")
        print(f"our customers {st_names}")
        print("press 1 to borrow book from our library")
        print("press 2 to return book you have borrowed")
        print("press 9 to exit")
        option = int(input())
        if option == 1:
            borrowbook()
        elif option == 2:
            returnbook()
        elif option==9:
            break

