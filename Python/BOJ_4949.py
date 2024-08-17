while True:
    string = input()
    if string == '.':
        break
    
    stack=[]
    flag=1
        for i in string:
        if i == '[' or i == '(':
            stack.append(i)
            
        elif i == ']':
            if not stack or stack[-1] != '[': #or 연산자 순서 유의
                flag=0
                break
            elif stack[-1]=='[':
                stack.pop()
            
        elif i == ')':
            if not stack or stack[-1] != '(':
                flag=0
                break
            elif stack[-1]=='(':
                stack.pop()
                
    if flag ==1 and not stack:
        print('yes')
    else:
        print('no')
