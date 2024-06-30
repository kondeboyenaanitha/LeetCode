class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        def generator(nums,index,subset,res):
            if index >=len(nums):
                res.append(subset.copy())
                return res
            subset.append(nums[index])
            generator(nums,index+1,subset,res)
            subset.pop()
            generator(nums,index+1,subset,res)
            return res
        res=generator(nums,0,[],[])
        return res     

        