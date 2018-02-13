import argparse
def check_alphabets(ss):
    # 알파벳 외 문자 확인
    count=0
    NotAlpha=[]
    for i in range(len(ss)):
        if not ss[i].isalpha():
            NotAlpha.append(i)
    # 알파벳 외 문자 제거 
    for i in range(len(NotAlpha)):
        ss=ss[0:NotAlpha[i]]+ss[NotAlpha[i]+1:]
        for j in range(len(NotAlpha)): NotAlpha[j]-=1
    # 대문자->소문자
    return ss.lower()

def split_sentences(s1,s2):
    s1=check_alphabets(s1)
    s2=check_alphabets(s2)
    # 쪼개기
    sentence1=[]
    sentence2=[]
    for i in range(len(s1)-1): sentence1.insert(i,s1[i:i+2])
    for i in range(len(s2)-1): sentence2.insert(i,s2[i:i+2])

def check_overlapping(letters,collection):
    for i in range(len(collection)):
        if letters==collection[i]:
            return True

def Scoring(s1,s2):
    intersection=[]
    Union=[]
    for i in range(len(s1)):
        for j in range(len(s2)):
            if s1[i]==s2[j] :
                if not check_overlapping(s1[i],intersection): intersection.append(s1[i])
                if not check_overlapping(s1[i],Union): Union.append(s1[i])
            elif s1[i]!=s2[j]:
                if not check_overlapping(s1[i],Union): Union.append(s1[i])
                if not check_overlapping(s2[i],Union): Union.append(s2[i])
    return int(len(intersection)/len(Union)*65536)

def get_argument():
    parser = argparse.ArgumentParser()
    parser.add_argument("stc1",type=str,help="비교할 첫번째 단어를 입력해주세요. (문자열의 길이는 2 이상, 1,000 이하)")
    parser.add_argument("stc2",type=str,help="비교할 두번째 단어를 주세요. (문자열의 길이는 2 이상, 1,000 이하)")
    
    args = parser.parse_args()

    stc1 = args.stc1
    stc2 = args.stc2

    return stc1,stc2

# 메인 함수
if __name__=="__main__":
    stc1,stc2=get_argument()
    stc1,stc2=split_sentences(stc1,stc2)
    print (Scoring(stc1,stc2))

