def sum(string):
    result=0
    for s in string:
        if s.isdigit():#For true
            result+=int(s)
    return result

N=int(input())
products=[]

for _ in range(N):
    products.append(input())

products.sort(key = lambda x:(len(x), sum(x), x))

for s in products:
    print(s)
