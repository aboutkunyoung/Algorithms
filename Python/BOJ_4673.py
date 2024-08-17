optimizedAnswer=""


def func1(N):
    global optimizedAnswer
    NLength = len(str(N))
    region=NLength * 9
    flag=1
    for j in range(max(1, N - region), N+1):
        value = j + sum_of_num(j)

        if value==N:
            flag = 0
            break
        if N - value > region:
            break
    if flag:
        optimizedAnswer += str(N) + "\n"
    
def sum_of_num(n):
    Sum=0
    for i in map(int, str(n)):
        Sum+=i
    return Sum

for i in range(1, 10001):
    func1(i)
print(optimizedAnswer)
