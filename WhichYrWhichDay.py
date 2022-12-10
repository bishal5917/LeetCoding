def WhichYrWhichDay(yr):

    days = [
        "Monday",
        "Tuesday",
        "Wednesday",
        "Thursday",
        "Friday",
        "Saturday",
        "Sunday",
        "None",
    ]
    day = 0
    start = 1
    while start != yr:
        if CheckleapYear(start):
            day += 2
            if day == 7:
                day = 0
            if day == 8:
                day = 1
            start += 1
        else:
            day += 1
            if day >= 7:
                day = 0
            start += 1

    return days[day]


def CheckleapYear(year):
    if (year % 400 == 0) and (year % 100 == 0):
        return True
    elif (year % 4 == 0) and (year % 100 != 0):
        return True
    else:
        return False


if __name__ == "__main__":
    yr = int(input("Enter the Year : "))
    print(WhichYrWhichDay(yr))
