import pickle 

#animes=["aot","fmab","dnote","dororo","monster"]
#file="animefile.pkl"
#fileobj=open(file,"wb")
#pickle.dump(animes,fileobj)

file="animefile.pkl"
fileobject=open(file,"rb")
x=pickle.load(fileobject)
print(x)
print(type(x))


