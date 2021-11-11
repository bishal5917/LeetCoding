import PyPDF2

a=PyPDF2.PdfFileReader("Demo.pdf")

str=" "
for i in range(10):
    str+=a.getPage(i).extractText()

with open ("extracted.txt","w",encoding='UTF-8') as f:
    f.write(str)