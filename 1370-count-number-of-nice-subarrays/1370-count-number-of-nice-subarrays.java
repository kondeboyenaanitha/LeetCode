class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int count = 0, prefixCount = 0, result = 0;
        int[] prefixSums = new int[nums.length + 1];
        prefixSums[0] = 1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 != 0) {
                count++;
            }

            if (count >= k) {
                result += prefixSums[count - k];
            }

            prefixSums[count]++;
        }

        return result;
    }
}
