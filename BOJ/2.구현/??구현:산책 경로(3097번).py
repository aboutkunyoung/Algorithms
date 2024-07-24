N=int(input())
arr =[]
x, y = 0, 0

t_x, t_y=0, 0

for _ in range(N):
    a, b = map(int, input().split())
    arr.append([a, b])
    x+=a
    y+=b
    a**2
    b**2
    if a**2+b**2 > t_x**2+t_y**2:
        t_x, t_y=a, b

print(x, y)
print(x-t_x, y-t_y)