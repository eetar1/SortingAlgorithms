import random
with open("testFile.txt","w+") as fp:
    values = [i for i in range(0,1001)]
    random.shuffle(values)
    for i in values:
        fp.write(str(i)+" ")
