from flask import Flask,jsonify

app=Flask(__name__)

@app.route('/')
def letsCreate():
    return "This is my rest API using flask"


@app.route('/binary/<int:n>')
def check(n):
    if n==0 or n==1:
        print("Binary Digit")
        result={
            "Digit" : n,
            "binary":True,
            "IP":"127.0.0.1"
        }
    else:
        print("Not Binary")
        result={
            "Digit" : n,
            "binary":False,
            "IP":"127.0.0.1"
        }
    return jsonify(result)


if __name__=="__main__":
    app.run(debug=True)
