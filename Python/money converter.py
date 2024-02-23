
with open('currencytable.txt') as f:
    lines=f.readlines()

currDict={}

for line in lines:
    parsed=line.split("\t")
    currDict[parsed[0]]=parsed[1]

amt=int(input("enter the amount you want to convert"))
print("enter the name of the currency you want to convert to")
print("your available options are")
print([print(item) for item in currDict.keys()])
currencyto=input("print one of these values")
print(f"the {amt} nepalese rupee is equal to {amt*float(currDict[currencyto])} {currencyto}")