import java.util.Stack;

class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        
        // Add a sentinel bar of height 0 at the end
        int[] extended = new int[heights.length + 1];
        System.arraycopy(heights, 0, extended, 0, heights.length);
        extended[heights.length] = 0;
        
        for (int i = 0; i < extended.length; i++) {
            while (!stack.isEmpty() && extended[stack.peek()] > extended[i]) {
                int height = extended[stack.pop()];
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                maxArea = Math.max(maxArea, height * width);
            }
            stack.push(i);
        }
        
        return maxArea;
    }
}
