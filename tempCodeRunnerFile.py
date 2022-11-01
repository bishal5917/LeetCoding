    for i in range(localmin, len(arr) - 1):
            # if i not in localmins:
            if arr[i + 1] > arr[i]:
                rewards[i + 1] = max(rewards[i + 1], rewards[i] + 1)
        for i in reversed(range(localmin + 1)):
            # if i not in localmins:
            if arr[i - 1] > arr[i]:
                rewards[i - 1] = max(rewards[i - 1], rewards[i] + 1)