N=int(input())
a=list(map(int, input().split()))

Arr=list(sorted(set(a))) #eliminate same value

ans_sheet={value:index for index, value in enumerate(Arr)}
#get index

for element in a:
    print(ans_sheet[element], end=" ")