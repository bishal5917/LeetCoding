
def check(sentence1,sentence2):
    score=0
    words1=sentence1.split(" ")
    words2=sentence2.split(" ")
    for word1 in words1:
        for word2 in words2:
            if word1==word2:
                score+=1
    return score

if __name__=="__main__":
    # print(check("This is good","This isnot good"))
    searchinglist=["This is coding world","This is good"," THis is not fantasy"]
    search=input("ENter the string you wanna search\n")
    # print(check(search,"This isnot good"))
    scores=[check(search,words) for words in searchinglist]
    # print(scores)
    sent_score_sort=[sentscore for sentscore in sorted(zip(scores,searchinglist),reverse=True)]
    # print(sent_score_sort)

    for index,item in sent_score_sort:
        print(f" found {item} with a score of {index} \n")


