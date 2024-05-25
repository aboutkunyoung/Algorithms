T=int(input())

# 거꾸로 순회하면서 최댓값 찾고, 최솟값에서 팔기

for _ in range(1, T+1):
    
    N = int(input())
    Arr_list = list(map(int, input().split()))
    answer =0
    sellprice=0

    for i in range(N-1, -1, -1):
        if Arr_list[i] >= sellprice:
            sellprice = Arr_list[i]
        else:
            answer = answer + sellprice - Arr_list[i]

    print("#%d %d" %(_, answer))