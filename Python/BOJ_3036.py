def gcd(a, b):
    while(b != 0):
        n = a%b
        a = b
        b = n
    return a


N=int(input())
arr_list=list(map(int, input().split()))


for i in range(1, N):
    key=gcd(arr_list[0],arr_list[i])
    print("%d/%d" %(arr_list[0]//key, arr_list[i]//key))
