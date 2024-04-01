S=input()+' '

temp=''
idx=0

while idx<len(S):
    if S[idx]==' ':
        print(temp[::-1], end=" ")
        temp=""
    elif S[idx]=="<":
        print(temp[::-1], end="")
        temp=''
        tag=S.find('>', idx)
        print(S[idx:tag+1], end="")
        idx=tag
    else:
        temp+=S[idx]
    idx+=1