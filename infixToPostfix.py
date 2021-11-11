import string

def infixToPostfix():
    matching = {"(": ")", "{": "}", "[": "]"}
    openingBrackets="({["
    closingbrackets=")}]"
    operator="+-*/"
    alphabets="abcdefghijklmnopqrstuvwxyz"
    stacks=[]
    postfixExp=[]

    givenexp="a-buu++nc)("
    for item in givenexp:
        if item in alphabets:
            postfixExp.append(item)
        elif item in openingBrackets:
            stacks.append(item)
        elif item in operator:
            if stacks[-1]==item:
                postfixExp.append(item)
            else:
                stacks.append(item)
        # elif item
    print(postfixExp)
    print(stacks)

infixToPostfix()



