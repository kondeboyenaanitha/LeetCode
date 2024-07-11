class Solution {
    public int subarrayBitwiseORs(int[] arr) {
        HashSet<Integer> prev_set = new HashSet<>();
        HashSet<Integer> curr_set;
        HashSet<Integer> result_set = new HashSet<>();
    
        for (int cv : arr) {
            curr_set = new HashSet<>();
            curr_set.add(cv);
            for (int key : prev_set) {
                curr_set.add(key | cv);
            }
            prev_set = curr_set;
            result_set.addAll(curr_set);
        }
        return result_set.size();
    }
}