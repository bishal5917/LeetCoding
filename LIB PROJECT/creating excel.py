
import xlsxwriter

workbook = xlsxwriter.Workbook('file.xlsx')

worksheet = workbook.add_worksheet()

p=["dy","dys"]
worksheet.write('A1', 'Hello,1,2')
worksheet.write('B1', str(p))
x="dy"

if x in 'B1':
    print("yEs")

workbook.close()