import sys
input = sys.stdin.readline

def prime_list(N):
    sieve = [True] * N
    M = int(N**0.5)#만약 N이 100이라 가정했을 때, 최대 그의 제곱근만 되면 다 지울 수 있음
    for i in range(2, M+1):
        if sieve[i] == True:
            for j in range(i*i, N, i):
                sieve[j] = False
    return [i for i in range(2, N) if sieve[i]==True]

M, N = map(int, input().split())
p_list=prime_list(N+1)

for i in p_list:
    if M<=i<=N:
        print(i)