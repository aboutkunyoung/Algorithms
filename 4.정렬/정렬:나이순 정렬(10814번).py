import sys
input=sys.stdin.readline

N=int(input())

people_list=[list(map(str, input().split())) for _ in range(N)]
people_list=[[int(x), y] for x, y in people_list]
#print(people_list)

people_list.sort(key=lambda x:x[0])

for i in range(N):
    print(people_list[i][0], people_list[i][1])
