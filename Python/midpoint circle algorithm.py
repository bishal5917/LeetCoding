def Midpoint(r, xc, yc):
    x = 0
    y = r

    # print("the plot value is", (xc+x, yc+y)) uncomment this if you want the first value

    p = 1-r
    while(x <= y):
        if (p < 0):
            pk = 2*x+p+1
            x = x+1
            y = y
            print(f"x={x} and Y={y} and pk={pk}")
            print("the plot value is", (xc+x, yc+y))
        else:
            pk = p+2*x-2*y+1
            y = y-1
            x = x+1
            print(f"x={x} and Y={y} and pk={pk}")
            print("the plot value is", (xc+x, yc+y))

        if (x > y):
            print("not necessary anymore")


if __name__ == "__main__":
    Midpoint(10, 50, 50)
    #change arguments according to your need 