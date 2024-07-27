class Solution {
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
 
    long [][] matrix = new long[26][26];

    for(int i=0;i<26;i++) {
        for(int j=0;j<26;j++) {
            matrix[i][j] = Integer.MAX_VALUE;
        }
    }

    for(int i=0;i<original.length;i++) {
		int x = original[i]-'a';
		int y = changed[i]-'a';
        matrix[x][y] = Math.min(matrix[x][y],cost[i]);
    }	

    for(int k=0;k<26;k++) {
        for(int i=0;i<26;i++) {
            for(int j=0;j<26;j++) {
            matrix[i][j] = Math.min(matrix[i][j],matrix[i][k]+matrix[k][j]);
            }
        }
    } 

    long ans=0;
    
    for(int i=0;i<source.length();i++) {
        int x = source.charAt(i)-'a';
        int y = target.charAt(i)-'a';
        if(x == y) continue;

        if(matrix[x][y] == Integer.MAX_VALUE) return -1;
        ans+=matrix[x][y];
    }
      
    return ans;
    }
}