T=int(input())

for _ in range(1, T+1):
    A, B, C = map(int, input().split())
    
    if B>=2 and C>=3:
        if A<B and B<C:
            print("#%d 0" %(_))
        else:
            cnt=0
            if B>=C:
                cnt = cnt + B-C+1
                B = C-1 #먹는걸 최소화 해야하니까.
            if A >= B:
                cnt = cnt + A - B +1
                a = B - 1
            print("#%d %d" %(_, cnt))
    else:
        print("#%d -1" %(_))



