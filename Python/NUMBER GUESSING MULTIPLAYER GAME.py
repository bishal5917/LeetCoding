import random

a = int(input("Enter first number for our game\n"))
b = int(input("Enter second number for our game\n"))

gen_num1 = random.randint(a, b)
gen_num2 = random.randint(a, b)
# print(gen_num)
print("  Number Generated between first and second number , Be Ready to Guess ")
trial1 = 1   # Because first won't be inside while loop
trial2 = 1  # Because first won't be inside while loop


def OurGame():
    global trial1, trial2, gen_num1, gen_num2

    print("******PLAYER ONE's TURN******")
    name1 = input(" Enter Your Name\n")
    guessed_by_p1 = int(input("Guesss the number "))
    while (guessed_by_p1 != gen_num1):
        trial1 += 1
        guessed_by_p1 = int(input(" Wrong , Guess Again "))
    print(f"Correct , {name1} took {trial1} trials")

    print("*****PLAYER TWO's TURN*****")
    name2 = input(" Enter Your name\n")
    guessed_by_p2 = int(input("Guesss the number "))
    while (guessed_by_p2 != gen_num2):
        trial2 += 1
        guessed_by_p2 = int(input(" Wrong , Guess Again "))
    print(f"Correct , {name2} took {trial2} trials")

    if trial1 < trial2:
        print(f"{name1} is the Winner , Congratulations {name1} !!! ")
    else:
        print(f"{name2} is the Winner , Congratulations {name2} !!! ")


if __name__ == "__main__":
    OurGame()
