
 '''
try:
    con_string = r'DRIVER={Microsoft Access Driver (*.mdb, *.accdb)};' \
                 r'DBQ=C:\Users\parwizforogh\Documents\msdatabase.accdb;'
    conn = pyodbc.connect(con_string)
 
    cursor = conn.cursor()
 
    myuser = (
 
        (6, 'data', 'data@gmail.com'),
        (7, 'python', 'python@gnail.com'),
        (8, 'java', 'java@gmail.com'),
 
    )
 
    cursor.executemany('INSERT INTO users VALUES (?,?,?)', myuser)
    conn.commit()
    print('Data Inserted')
 
 
except pyodbc.Error as e:
    print("Error in connection", e)


try:
    con_string = r'DRIVER={Microsoft Access Driver (*.mdb, *.accdb)};' \
                 r'DBQ=C:\Users\parwizforogh\Documents\msdatabase.accdb;'
    conn = pyodbc.connect(con_string)
 
    cur = conn.cursor()
    cur.execute('SELECT * FROM users')
 
    for row in cur.fetchall():
        print(row)
 
 
 
except pyodbc.Error as e:
    print("Error in Connection")


try:
    con_string = r'DRIVER={Microsoft Access Driver (*.mdb, *.accdb)};' \
                 r'DBQ=C:\Users\parwizforogh\Documents\msdatabase.accdb;'
    conn = pyodbc.connect(con_string)
 
    user_id = 2
 
    cur = conn.cursor()
    cur.execute('DELETE FROM users WHERE id = ?', (user_id))
    conn.commit()
    print("Data Deleted ")
 
 
except pyodbc.Error as e:
    print("Error in connection", e)
    '''