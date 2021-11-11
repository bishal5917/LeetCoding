try:
    #f=open("gone.txt")
    f1=open("currencytable.txt")

except Exception as e:
    print("no file",e)

else:
    print("This is getting printed because there was no any exception")

finally:
    print("this is to be printed anyhow")