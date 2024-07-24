N, M = map(int, input().split())
list_a=[list(map(int, input().split())) for _ in range(N)]
K = int(input())

for _ in range(K):
    i, j, x, y = map(int, input().split())
    sum_a=0
    for k in range(i-1, x):
        for m in range(j-1, y):
            sum_a+=list_a[k][m]
    print(sum_a)