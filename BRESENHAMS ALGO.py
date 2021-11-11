def Bresenhams(x1, y1, x2, y2):
    dx = x2-x1
    dy = y2-y1
    i1 = 2*dy
    i2 = 2*(dy-dx)
    d = i1-dx

    while (x1 != x2):
        if (d < 0):
            x1 = x1+1                         
            y1 = y1
            d = d+i1
            print(f'd = {d}')
            print("plot is", (x1, y1))

        elif (d >= 0):
            x1 = x1+1
            y1 = y1+1
            d = d+i2
            print(f'd = {d}')
            print("plot is", (x1, y1))


if __name__ == "__main__":
    Bresenhams(10,18,15,8)
