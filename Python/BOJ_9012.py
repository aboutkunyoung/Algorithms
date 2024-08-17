N=int(input())

## 괄호가 열릴 때 푸시
## 괄호가 닫힐 때는 팝

for _ in range(N):
    a=list(input())
    stack=[]
    flag=0
    for i in a:
        if i == '(' :
            stack.append(i)
        elif i==')':
            if len(stack)==0:
                flag=1
                print("NO")
                break
            else:
                stack.pop()
    if flag:
        continue
    
    if len(stack) > 0:
        print("NO")
        continue
        
    print("YES")
        
