T=int(input())

for _ in range(1, T+1):
    
    N = int(input())
    ck = 0
    for i in range(1, 10):
        for j in range(1, 10):
            if i*j == N:
                ck = 1
    
    if ck == 1:
        print("#%d Yes" %(_))
    else:
        print("#%d No" %(_))