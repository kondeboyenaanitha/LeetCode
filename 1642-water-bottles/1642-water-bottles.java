class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int ans=numBottles;
        ans+=find(numBottles,numExchange,0);
        return ans;
        
    }
    int find(int cur,int ex,int count){
        if(cur<ex) return count;
        count+=cur/ex;
        cur=cur/ex+cur%ex;
        return find(cur,ex,count);
    }
}