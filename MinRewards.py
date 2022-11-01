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


if __name__ == "__main__":
    arr = [8, 4, 2, 1, 3, 6, 7, 9, 5]
    print(MinRewards1(arr))
