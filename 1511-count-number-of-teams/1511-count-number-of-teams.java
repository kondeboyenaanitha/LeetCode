import java.util.*;

class Solution {
    public int numTeams(int[] rating) {
        int n = rating.length;
        if (n < 3) return 0;
        
        List<Soldier> soldiers = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            soldiers.add(new Soldier(rating[i], i));
        }
        
        Collections.sort(soldiers);
        
        int[] indexMap = new int[n];
        for (int i = 0; i < n; i++) {
            indexMap[soldiers.get(i).index] = i;
        }
        
        int teams = 0;
        
        teams += countTeams(indexMap, n, true);
        
        teams += countTeams(indexMap, n, false);
        
        return teams;
    }
    
    private int countTeams(int[] indexMap, int n, boolean ascending) {
        int[] bit = new int[n + 1];
        int teams = 0;
        
        for (int i = 0; i < n; i++) {
            int rank = indexMap[i] + 1;
            int left = ascending ? getSum(bit, rank - 1) : getSum(bit, n) - getSum(bit, rank);
            int right = ascending ? n - rank - (getSum(bit, n) - getSum(bit, rank)) : rank - 1 - getSum(bit, rank - 1);
            teams += left * right;
            update(bit, rank, 1);
        }
        
        return teams;
    }
    
    private void update(int[] bit, int index, int val) {
        while (index < bit.length) {
            bit[index] += val;
            index += index & (-index);
        }
    }
    
    private int getSum(int[] bit, int index) {
        int sum = 0;
        while (index > 0) {
            sum += bit[index];
            index -= index & (-index);
        }
        return sum;
    }
    
    private class Soldier implements Comparable<Soldier> {
        int rating;
        int index;
        
        Soldier(int rating, int index) {
            this.rating = rating;
            this.index = index;
        }
        
    
        public int compareTo(Soldier other) {
            return Integer.compare(this.rating, other.rating);
        }
    }
}