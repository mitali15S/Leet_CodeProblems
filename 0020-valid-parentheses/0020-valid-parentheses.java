import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        
        for (char c : s.toCharArray()) {
            // Push the corresponding closing bracket onto the stack
            if (c == '(') {
                stack.push(')');
            } else if (c == '{') {
                stack.push('}');
            } else if (c == '[') {
                stack.push(']');
            } 
            // If it's a closing bracket, it must match the popped element
            else if (stack.isEmpty() || stack.pop() != c) {
                return false;
            }
        }
        
        // Valid only if all opened brackets find their match
        return stack.isEmpty();
    }
}
