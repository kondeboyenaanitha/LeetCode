class Solution:
    def canJump(self, nums: List[int]) -> bool:
        def jump(nums,index):
            n=len(nums)-1
            memo=[]
            for i in range(n+1):
                memo.append(False)
            memo[n]=True
            for i in range(n-1,-1,-1):
                far=min(i+nums[i],n)
                for j in range(i+1,far+1):
                    if memo[j]==True:
                        memo[i]=True
                        break
            return memo[0]
        return jump(nums,0)     
                 

        