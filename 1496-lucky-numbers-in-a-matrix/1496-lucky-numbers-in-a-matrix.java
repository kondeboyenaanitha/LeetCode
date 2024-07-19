class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {
        int m=matrix.length, n=matrix[0].length;
        int[] maxCols=new int[n];
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                maxCols[i] = Math.max(maxCols[i], matrix[j][i]);
        for(int i=0;i<m;i++){
            int minRow=matrix[i][0],colIndex=0;
            for (int j = 1; j < n; j++)
                if (matrix[i][j] < minRow){
                    minRow = matrix[i][j];
                    colIndex = j;
                }
            if (minRow == maxCols[colIndex])
                res.add(minRow);
        }
        return res;      

        
    }
}