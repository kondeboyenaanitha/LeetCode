class Solution {
    
    private String start, dest;
    private StringBuilder path = new StringBuilder();

    public String getDirections(TreeNode root, int startValue, int destValue) {
        int i = 0;
        StringBuilder output = new StringBuilder();
        getDirections(startValue, destValue, root);
        while (i < start.length() && i < dest.length() && start.charAt(i) == dest.charAt(i)) i++;
        for (int j = i; j < start.length(); j++) output.append('U');
        for (int j = i; j < dest.length(); j++) output.append(dest.charAt(j));
        return output.toString();
    }

    private void getDirections(int startValue, int destValue, TreeNode root) {
        if (root == null) return;
        if (startValue == root.val) start = path.toString();
        else if (destValue == root.val) dest = path.toString();
        path.append('L');
        getDirections(startValue, destValue, root.left);
        path.setCharAt(path.length() - 1, 'R');
        getDirections(startValue, destValue, root.right);
        path.setLength(path.length() - 1);
    }

}