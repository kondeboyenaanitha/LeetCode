class Solution {
    public int minimumSum(int num) {
        final List<Integer> nums = new ArrayList<>();

        while(num > 0) {
            nums.add(num % 10);
            num /= 10;
        }

        Collections.sort(nums);

        int first = 0, second = 0;

        for(int i = 0; i < nums.size(); ++i) {
            if(i % 2 == 0) {
                first *= 10;
                first += nums.get(i);
            } else {
                second *= 10;
                second += nums.get(i);
            }
        }

        return first + second;
    }
}