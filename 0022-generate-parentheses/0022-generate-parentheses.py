class Solution:
    def generateParenthesis(self, n: int) -> List[str]:
        def generator(n,open,close,res,curr):
            if len(curr)==n*2:
                res.append(curr)
                return 
            else:
                if open<n:
                    generator(n,open+1,close,res,curr+'(') 
                if close<open:
                    generator(n,open,close+1,res,curr+')')
            return res         
        res=[]
        res=generator(n,0,0,res,'')
        return res                