N=int(input())

#문자열로 생각해야지 멍청아.......

for i in range(1, N+1):
    i=str(i)
    clap = i.count('3') +i.count('6') + i.count('9')

    if clap == 0:
        print(i, end=" ")
    else:
        print("-" * clap, end=" ")