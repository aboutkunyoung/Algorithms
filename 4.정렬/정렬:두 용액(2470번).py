N = int(input())

a = list(map(int, input().split()))
a = sorted(a)

i=0
j=N-1

target = abs(a[i]+a[j])
ans_set = [a[i], a[j]]

while i < j :
    tmp =abs(a[i] + a[j])
    if tmp < target:
        target = abs(tmp)
        ans_set = [a[i], a[j]]
        if abs(tmp) == 0 :
            break
    
    if tmp<0:
        i+=1
    else:
        j-=1

print(ans_set[0], ans_set[1])
