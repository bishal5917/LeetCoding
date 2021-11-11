import pandas as pd

import xlsxwriter

workbook = xlsxwriter.Workbook('file.xlsx')

worksheet = workbook.add_worksheet()

p=["dy","dys"]
worksheet.write('A1', 'Hello,1,2')
worksheet.write('B1', str(p))


info=pd.read_excel(r'D:\PYTHON PROGRAMS\LIB PROJECT\file.xlsx')
# print(info)

uio="dys"
for index,item in info.iterrows():
    x=(item['books'])
    # print(x)
    
    if uio not in x:
        print("NO")
        break
    else:
        print("Yes")
        break

worksheet.Close()