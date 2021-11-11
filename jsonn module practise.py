import json

data='{"val1":"python","val2":"C++"}'
parsed=json.loads(data)
print(parsed['val1'])
print(parsed['val2'])

data2={"none":"dodod","languages":["py","c++","c"],"istrue":False}

jscomp=json.dumps(data2)
print(jscomp)