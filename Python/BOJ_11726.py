import sys
input = sys.stdin.readline

N=int(input())
d=[0]*(N+1)

d[1] = 1
d[2] = 2

for i in range(3, N+1):
    d[i] = (d[i-1] + d[i-2]) % 10007

print(d[N])

