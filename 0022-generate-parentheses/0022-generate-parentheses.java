import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(result, "", 0, 0, n);
        return result;
    }

    private void backtrack(List<String> result, String current, int open, int close, int max) {
        // Base case: Valid combination found
        if (current.length() == max * 2) {
            result.add(current);
            return;
        }

        // Decision 1: Add an open parenthesis
        if (open < max) {
            backtrack(result, current + "(", open + 1, close, max);
        }

        // Decision 2: Add a close parenthesis
        if (close < open) {
            backtrack(result, current + ")", open, close + 1, max);
        }
    }
}
