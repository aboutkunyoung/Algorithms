import sys
input = sys.stdin.readline

T=int(input())

#개미가 충돌하는건 신경안써도 됨.
#충돌에서 나아가면 그 개미가 같은 개미로 봐도 무방

for _ in range(T):
    L,n=map(int, input().split())
    ants=[]
    for _ in range(n):
        ants.append(int(input()))
    antMin=0
    antMax=0
    for ant in ants:
        antMin = max(antMin, min(ant, L-ant))
        #끝으로 가장 빠르게 떨어지는 개미중 가장 오래걸리는 값
        antMax = max(antMax, ant, L-ant)
        #가장 자리에 있는 개미가 반대편 모서리까지 가는데 걸리는 것 중 가장 느린 값
    print(antMin,antMax)