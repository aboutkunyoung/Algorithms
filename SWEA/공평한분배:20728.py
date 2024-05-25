#20728. 공평한 분배 2
#https://swexpertacademy.com/main/solvingProblem/solvingProblem.do

T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    N, K = map(int, input().split())
    a = list(map(int, input().split()))
    
    tmp = 1000000000 #최댓값 잘넣어줘야 모든 테스트 케이스에 대하여 맞는다.
    
    a=sorted(a)

    for i in range(0, N-K+1):
        if tmp > a[i+K-1]-a[i]:
            tmp = a[i+K-1]-a[i]

    print("#%d %d" %(test_case, tmp))