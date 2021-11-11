import pyodbc
conn = pyodbc.connect(r'Driver={Microsoft Access Driver (*.mdb, *.accdb)};DBQ= D:\PYTHON PROGRAMS\LIB PROJECT\LIBSS.accdb')
cursor = conn.cursor()


cursor.execute('''
                    INSERT INTO Sheet1:Table (name, books)
                    VALUES('Mike', 'Jordan')

                  ''')
try: 
    conn.commit()
except Exception as e:
    print(e)