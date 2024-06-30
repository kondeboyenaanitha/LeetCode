class Solution {
    public int minOperations(int[] nums) {
        int flipCount =1-nums[nums.length-1];
        for (int i = 0; i < nums.length-1; i++) {
         if(nums[i]==0 && nums[i+1]==1){
            flipCount+=2;
        }
        }
        return flipCount;
    }
}