print("Enter your age or your Date of birth")
x = input()

if len(x) <= 3:
    age = int(x)
    if age > 100:
        print(" EXCEPTION : It cant be possible")
    elif age <= 0:
        print(" EXCEPTION : You arenot born yet ")
    elif age > 0 and age < 100:
        print(f"You will be 100 yrs old after {100-age} years")
    elif age == 100:
        print("You are already 100 years old ")
elif len(x) == 4:
    dob = int(x)
    if dob < 1921:
        print(" EXCEPTION : You seem to be the oldest person alive")
    elif dob > 2021:
        print(" EXCEPTION : You are not Born yet")
    elif dob == 2021:
        print(" Probably you will hit 100 on 2121 and you are a year old")
    else:
        print(f"You are {2021-dob} years old")
        print(f"You will be 100 years old on {dob+100}")
