N=int(input())
num=2
while True:
    if N==1:
        break
    if N%num==0:
        print(num)
        N=N//num
    else:
        num+=1
    
