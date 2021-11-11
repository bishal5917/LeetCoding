# connecting to the database
import pyodbc
 
msa_drivers = [x for x in pyodbc.drivers() if 'ACCESS' in x.upper()]
print(f'MS-Access Drivers : {msa_drivers}')

try:
    conn = pyodbc.connect("DRIVER={Microsoft Access Driver (*.mdb, *.accdb)};DBQ=D:\\PYTHON PROGRAMS\\LIB PROJECT\\lib.accdb")
    print("Successfully Connected to the database")
 
 
except pyodbc.Error as e:
    print("Error", e)
# ///////////////////////////////////////////////////////////////////
#inserting into the database
def insert():
    try:
        con_string = r'DRIVER={Microsoft Access Driver (*.mdb, *.accdb)};' \
                    r'DBQ=D:\\PYTHON PROGRAMS\\LIB PROJECT\\lib.accdb;'
        conn = pyodbc.connect(con_string)
    
        cursor = conn.cursor()
    
        to_insert = (
    
            (3, 'noob', 'noob book'),
            (4, 'pro', 'pro book'),
            (5, 'legend', 'legendary buk'),
    
        )
    
        cursor.executemany('INSERT INTO Table1 VALUES (?,?,?)', to_insert)
        conn.commit()
        print('Data Inserted')
    
        
    except pyodbc.Error as e:
        print("Error in connection", e)

# /////////////////////////////////////////////////////////////////////////////////////////////////
# checking the database
def check():
    try:
        con_string = r'DRIVER={Microsoft Access Driver (*.mdb, *.accdb)};' \
                    r'DBQ=D:\\PYTHON PROGRAMS\\LIB PROJECT\\lib.accdb;'
        conn = pyodbc.connect(con_string)
    
        cur = conn.cursor()
        cur.execute('SELECT * FROM Table1')
    
        for row in cur.fetchall():
            print(row)
    
    except pyodbc.Error as e:
        print("Error in Connection")

# //////////////////////////////////////////////////////////////////////////////
# deleting from the database
def delete():
    try:
        con_string = r'DRIVER={Microsoft Access Driver (*.mdb, *.accdb)};' \
                    r'DBQ=D:\\PYTHON PROGRAMS\\LIB PROJECT\\lib.accdb;'
        conn = pyodbc.connect(con_string)
    
        user_id = 3   #specify which box/row to delete
    
        cur = conn.cursor()
        cur.execute('DELETE FROM Table1 WHERE id = ?', (user_id))
        conn.commit()
        print("Data Deleted ")
    
    
    except pyodbc.Error as e:
        print("Error in connection", e)

# //////////////////////////////////////////////////////////////
check()
