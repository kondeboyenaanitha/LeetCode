// ALgo: Using stack
// TC: O N , SC: O N
class Solution {
    public boolean isValid(String s) {
        Stack<Character> st= new Stack<>();
        int n= s.length();
        for(int i=0; i< n; i++){
            if(s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{'){
                st.push(s.charAt(i));
            }else{
                if(st.isEmpty()){ // imp check - this check tells that we have a closing bracket and the stack is empty that means bracket was not open but is closed
                    return false;
                }else{
                    char ch= st.pop();
                    // this whill check that for the corresponding closing bracket the top ele should be its openinig one
                    if(s.charAt(i) == ')' && ch != '('
                    || s.charAt(i) == ']' && ch != '['
                    || s.charAt(i) == '}' && ch != '{'){
                        return false;
                    }
                }
            }
        }
        return st.isEmpty(); // if stack is empty it returns true else it will return false
    }
}
