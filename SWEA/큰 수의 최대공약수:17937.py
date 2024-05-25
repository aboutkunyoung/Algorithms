T=int(input())

for _ in range(1, T+1):
    
    N, K = map(int, input().split())
    
    if N == K :
        GCD = N
    else:
        GCD = 1
    
    print("#%d %d" %(_, GCD))
