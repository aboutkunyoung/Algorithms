
T=int(input())
sb = [2, 3, 5, 7, 11]
for _ in range(1, T+1):
    N=int(input())
    sa = [0, 0 ,0 ,0 ,0]
        
    for i in range(5):
        while N % sb[i] == 0 :
            sa[i]+=1
            N//=sb[i]
        
    print("#%d " %(_), end="")
    for a in sa:
        print("%d " %a, end="")
    print()


