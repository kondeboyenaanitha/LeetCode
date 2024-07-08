class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int ans[] = new int[nums.length];
        for(int i = 0 ; i<nums.length ; i++){
            ans[i] = -1;
            int j = (i+1)%nums.length;
            while(i != j){
                if(nums[j] > nums[i]){
                    ans[i] = nums[j];
                    break;
                }
                else{
                    j = (j+1)%nums.length;
                }
            }
        }
        return ans;
    }
}