T=int(input())

for _ in range(1, T+1):
    
    N, K = map(int, input().split())
    arr_list =[]

    for i in range(N):
        arr_list.append(list(map(int, input().split())))
    
    for i in range(N):
        sum = 0

        for j in range(N):
            if arr_list[i][j] ==1 :
                sum+=1
            if arr_list[i][j] ==0 or j = N-1:
    
                    
      
    print(arr_list)
    #print("#%d %d" %(_, arr_list))