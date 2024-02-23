m=int(input("ENter the number of rows"))
n=int(input("ENter the number of columns"))

def matrixinp(m,n):
    matrx=[]
    for i in range (m):
        rows = []
        for j in range (n):
            print(f"Enter a{i}{j}")
            x= int(input())
            rows.append(x)
        matrx.append(rows)

    return matrx

print("Enter the first matrix")
A =matrixinp(m,n)
print("Enter the second matrix")
B=matrixinp(m,n)
print(f"Your first matrix is {A}")
print(f"Your second matrix is {B}")

def addition(A,B):
    c=[]
    for i in range(len(A)):
        row=[]
        for j in range (len(B[0])):
            x= A[i][j]+B[i][j]
            row.append(x)
        c.append(row)
    return c

print(f"The matrix after addition is {addition(A,B)}")

