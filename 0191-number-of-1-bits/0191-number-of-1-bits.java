class Solution {
    public int hammingWeight(int n) {
        int count=0;
        for(int i=0;i<=n;i++){
            n&=n-1;
            count+=1;
        }
        return count;
        
    }
}