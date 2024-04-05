import sys
input=sys.stdin.readline

N=int(input())

time = [list(map(int, input().split())) for _ in range(N)]
time.sort(key = lambda x:((x[1]), x[0]))

count=1
end_time = time[0][1]

for i in range(1, N):
    if time[i][0] >= end_time:
        end_time = time[i][1]
        count+=1

print(count)