T=int(input())

for _ in range(1, T+1):
    arr_list = list(map(int, input().split()))
    arr_list.remove(max(arr_list))
    arr_list.remove(min(arr_list))

    #a= 3.6 / print("%d" %a)
    
    ans = (sum(arr_list)/len(arr_list))

    print("#%d %d" %(_, round(ans)))