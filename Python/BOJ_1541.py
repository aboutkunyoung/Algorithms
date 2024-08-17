string = input()

str_list = string.split('-')


for i in range(len(str_list)):
    if '+' in str_list[i]:
        tmp_list = str_list[i].split('+')
        tmp_list = list(map(int, tmp_list))
        str_list[i]=sum(tmp_list)
    else:
        str_list[i] = int(str_list[i])

result=str_list[0]

for i in range(1, len(str_list)):
    result-=str_list[i]


    
print(result)
