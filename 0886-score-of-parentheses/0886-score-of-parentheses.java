class Solution {
    public int scoreOfParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        int sc = 0;
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(ch == '('){
                stack.push(sc);
                sc = 0;
            }
            else {
                sc = stack.pop() + Math.max(2 * sc, 1);
            }
        }
        return sc;
    }
}