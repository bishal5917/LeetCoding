
def ClassPhotos(red, blue):
    redmax = max(red)
    bluemax = max(blue)
    red.sort()
    blue.sort()
    idx = len(red)-1
    while (idx >= 0):
        if bluemax > redmax:
            if blue[idx] > red[idx]:
                idx -= 1
            else:
                return False
        elif redmax > bluemax:
            if red[idx] > blue[idx]:
                idx -= 1
            else:
                return False

    return True


if __name__ == "__main__":
    red = [5, 8, 1, 3, 4]
    blue = [6, 9, 2, 4, 5]
    print(ClassPhotos(red, blue))
