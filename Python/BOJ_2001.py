T=int(input())

for _ in range(1, T+1):
    
    N, M = map(int, input().split())
    arr_list =[]

    for i in range(N):
        arr_list.append(list(map(int, input().split())))
    
    sum = 0
    for si in range(0, N-M+1):
        for sj in range(0,N-M+1):
            cnt=0 #이 부분 확인
            for i in range(si, si+M):
                for j in range(sj, sj+M):
                    cnt += arr_list[i][j]
            if sum < cnt:
                sum = cnt 

    print("#%d %d" %(_, sum))

