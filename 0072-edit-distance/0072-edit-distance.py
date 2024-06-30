class Solution:
    def minDistance(self, word1: str, word2: str) -> int:
        def ed(s1,s2,m,n):
            memo=[]
            for i in range(m+1):
                row=[]
                for j in range(n+1):
                    row.append(0)
                memo.append(row)
            for i in range(n+1):
                memo[0][i]=i
            for i in range(m+1):
                memo[i][0]=i
            for i in range(1,m+1):
                for j in range(1,n+1):
                    if s1[i-1]==s2[j-1]:
                        memo[i][j]=memo[i-1][j-1]
                    else:
                        memo[i][j]=1+min(memo[i][j-1],memo[i-1][j],memo[i-1][j-1])                    
            return memo[m][n]
        return ed(word1,word2,len(word1),len(word2))
                           
        