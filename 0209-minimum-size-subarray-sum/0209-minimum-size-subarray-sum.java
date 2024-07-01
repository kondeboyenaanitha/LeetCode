class Solution 
{
    public int minSubArrayLen(int target, int[] nums) 
    {
        int result = Integer.MAX_VALUE;
        int left=0, val_sum=0;

        for(int i=0;i<nums.length;i++)
        {
            val_sum+=nums[i];

            while(val_sum>=target)
            {
                result = Math.min(result,i-left+1);
                val_sum = val_sum - nums[left];
                left++;
            }
        }
        if(result!=Integer.MAX_VALUE)
        return result;
        else
        return 0;
    }
}