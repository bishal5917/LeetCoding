
def ProductExceptSelf(arr):
    arrProd = []
    prod = 1
    for item in arr:
        prod *= item
    for item in arr:
        arrProd.append(prod//item)
    return arrProd


arr = [2, 3, 6, 3]
print(ProductExceptSelf(arr))
