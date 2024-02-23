# find the minimum number of rewards that can be given to students grades following
# two rules
# 1.Every student must get at least one reward
# 2.If grade at given position is less than grade at position-1,then it should get less
# --reward than that of element at position-1 and similar.
# ---NOTE---:Order of given array matters , donot sort the array

# NAIVE SOLUTION
# O(n^2) time and O(n) space
def MinRewards1(arr):
    rewards = [1 for _ in arr]

    for i in range(1, len(arr) - 1):
        j = i - 1
        if arr[i] > arr[j]:
            rewards[i] = rewards[j] + 1
        else:
            while arr[j] > arr[j + 1]:
                rewards[j] = max(rewards[j], rewards[j + 1] + 1)
                j = j - 1

    return rewards


# OPTIMAL SOLUTION
# O(n) time and O(n) space
def MinRewards2(arr):
    rewards = [1 for _ in arr]
    localmins = getLocalMins(arr)
    localmin = localmins[0]
    for localmin in localmins:   
        for i in range(localmin, len(arr) - 1):
            # if i not in localmins:
            if arr[i + 1] > arr[i]:
                rewards[i + 1] = max(rewards[i + 1], rewards[i] + 1)
        for i in reversed(range(localmin + 1)):
            # if i not in localmins:
            if arr[i - 1] > arr[i]:
                rewards[i - 1] = max(rewards[i - 1], rewards[i] + 1)
    return rewards


def getLocalMins(arr):
    mins = []
    for i in range(0, len(arr) - 1):
        if arr[i] < arr[i - 1] and arr[i] < arr[i + 1]:
            mins.append(i)

        if arr[i] > arr[i + 1] and i == len(arr) - 2:
            mins.append(i + 1)
    return mins


if __name__ == "__main__":
    arr = [8, 4, 2, 1, 3, 6, 7, 9, 5]
    print(MinRewards1(arr))
    print(MinRewards2(arr))
