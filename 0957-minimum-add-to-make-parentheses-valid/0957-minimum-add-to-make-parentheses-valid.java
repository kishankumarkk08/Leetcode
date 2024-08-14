class Solution {
    public int minAddToMakeValid(String s) {
        Stack <Character> stack = new Stack<>();
        int count = 0;
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(ch == '(') {
                stack.push(ch);
                count++;
            }
            else if(!stack.isEmpty() && ch == ')' && stack.peek() == '(') {
                stack.pop();
                count--;
            }
            else {
                count++;
            }
        }
        return count;
    }
}