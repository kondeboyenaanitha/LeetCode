class Solution {
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int m=rowSum.length,n=colSum.length;
        int[][] res=new int[m][n];
        for(int i=0,j=0;i<m&&j<n;){
            res[i][j]=Math.min(rowSum[i],colSum[j]);
            rowSum[i]-=res[i][j];
            colSum[j]-=res[i][j];
            i+=(rowSum[i]==0?1:0);
            j+=(colSum[j]==0?1:0);
        }
        return res;
        
    }
}