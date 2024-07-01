class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
        if (arr.length < 3) return false;
        int start = 0;
        while (true) {
            if (start + 2 >= arr.length) return false;
            if (arr[start] % 2 == 1 && arr[start + 1] % 2 == 1 && arr[start + 2] % 2 == 1) return true;
            if (arr[start + 2] % 2 != 1) {
                start = start + 3;
            } else {
                start++;
            }
            
        }
    }
}