#BruteForce Approach O(n^2) Time Complexity
def ValidStartingCity(dis, fuel, mpg):
    for startcityidx in range(len(dis)):
        milesRemaining = 0

        for currentcityidx in range(startcityidx, startcityidx+len(dis)):
            if milesRemaining < 0:
                continue

            currentcityidx = currentcityidx % len(dis)

            fuelfromcurrentcity=fuel[currentcityidx]
            distancetonext=dis[currentcityidx]
            milesRemaining+=fuelfromcurrentcity*mpg-distancetonext

        if milesRemaining>=0:
            return startcityidx

if __name__ == "__main__":
    distances = [5, 25, 15, 10, 15]
    fuel = [1, 2, 1, 0, 3]
    mpg = 10  # miles per galoon
    x = ValidStartingCity(distances, fuel, mpg)
    print(x)


# Better Approach with O(n) time complexity and constant space
def ValidStartingCity(dis, fuel, mpg):
    fuelremprev = 0
    city = 0
    for i in range(1, len(dis)):
        fuelrem = fuelremprev+fuel[i-1]*mpg-dis[i-1]
        if fuelrem < fuelremprev:
            city = i
        fuelremprev = fuelrem

    return city


if __name__ == "__main__":
    distances = [5, 25, 15, 10, 15]
    fuel = [1, 2, 1, 0, 3]
    mpg = 10  # miles per galoon
    x = ValidStartingCity(distances, fuel, mpg)
    print(x)
