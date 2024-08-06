N=int(input())
budget=list(map(int, input().split()))
M=int(input())

budget=sorted(budget)
start, end =1, budget[-1]
total=sum(budget)

if total<=M:
    ans=end #max
else:
    while start<=end:
        mid=(start+end)//2
        cost=0
        for i in budget:
            if i >mid:
                cost+=mid
            else:
                cost +=i
        if cost>M:
            end=mid-1
        else:
            start = mid+1
            ans=mid  


print(ans)
