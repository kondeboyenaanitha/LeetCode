class Solution {

    public int maximumGain(String s, int x, int y) {
        char first = x > y ? 'a' : 'b';
        char second = x > y ? 'b' : 'a';
        int min = Math.min(x,y);
        int max = Math.max(x,y);
        int ans = 0;

        Stack<Character> stack = new Stack();

        for(char ch: s.toCharArray()){
            if(!stack.isEmpty() && ch == second && stack.peek() == first){
                stack.pop();
                ans += max;
            }else{
                stack.push(ch);
            }
        }

        Stack<Character> stack2 = new Stack();


        while(!stack.isEmpty()){
            char ch = stack.pop();
            if(!stack2.isEmpty() && ch == second && stack2.peek() == first){
                stack2.pop();
                ans += min;
            }else{
                stack2.push(ch);
            }
        }

        return ans;
    }
}