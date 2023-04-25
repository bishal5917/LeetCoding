def dailyTemperatures(temperatures):
    output = [0 for _ in range(0, len(temperatures))]

    i = 0
    for i in range(0, len(temperatures) - 1):
        j = i + 1
        if temperatures[j] > temperatures[i]:
            output[i] = 1
        if temperatures[j] <= temperatures[i]:
            count = 1
            for x in range(j, len(temperatures)):
                if temperatures[x] <= temperatures[i]:
                    count += 1
                if temperatures[x] > temperatures[i]:
                    output[i] = count

    return output


if __name__ == "__main__":
    temps = [73, 74, 75, 71, 69, 72, 76, 73]
    temps = [89, 62, 70, 58, 47, 47, 46, 76, 100, 70]
    print(dailyTemperatures(temps))
