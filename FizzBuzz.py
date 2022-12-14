def FizzBuzz(n):
    output = ["0" for i in range(0, n)]

    for i in range(1, n + 1):
        if i % 3 == 0 and i % 5 == 0:
            output[i - 1] = "FizzBuzz"
        elif i % 3 == 0:
            output[i - 1] = "Fizz"
        elif i % 5 == 0:
            output[i - 1] = "Buzz"
        else:
            output[i - 1] = str(i)

    return output


if __name__ == "__main__":
    n = 5
    print(FizzBuzz(n))
