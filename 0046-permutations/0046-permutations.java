class Solution {
    public void swap(List<Integer> sl, int i, int j) {
        int temp = sl.get(i);
        sl.set(i, sl.get(j));
        sl.set(j, temp);
    }

    public void permutations(List<List<Integer>> ml, List<Integer> sl, int i) {
        if (i == sl.size()) {
            ml.add(new ArrayList<>(sl));
            return;
        }

        for (int j = i; j < sl.size(); j++) {
            swap(sl, i, j);
            permutations(ml, sl, i + 1);
            swap(sl, i, j);
        }

    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ml = new ArrayList<>();
        List<Integer> sl = new ArrayList<>();
        for (int el : nums) {
            sl.add(el);
        }
        permutations(ml, sl, 0);
        return ml;
    }
}
