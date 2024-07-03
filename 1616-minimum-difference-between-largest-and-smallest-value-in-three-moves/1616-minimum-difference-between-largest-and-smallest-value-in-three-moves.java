class Solution {
    public int minDifference(int[] nums) {
       int len = nums.length;
        if (len <= 4) {
            return 0;
        }
        Arrays.sort(nums);
        return Math.min(
            Math.min(nums[len - 4] - nums[0], nums[len - 3] - nums[1]),
            Math.min(nums[len - 2] - nums[2], nums[len - 1] - nums[3])
        ); 
    }
}