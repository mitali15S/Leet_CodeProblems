import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> results = new ArrayList<>();
        // 1. Sort the candidates to handle duplicates easily
        Arrays.sort(candidates);
        // 2. Start the backtracking process
        backtrack(results, new ArrayList<>(), candidates, target, 0);
        return results;
    }

    private void backtrack(List<List<Integer>> results, List<Integer> currentCombination, int[] candidates, int remain, int start) {
        // Base Case 1: Target reached
        if (remain == 0) {
            results.add(new ArrayList<>(currentCombination));
            return;
        }

        // Iterate through candidates starting from the current index
        for (int i = start; i < candidates.length; i++) {
            // Optimization: If the current number exceeds the remaining target, stop the loop
            if (candidates[i] > remain) {
                break;
            }

            // Skip duplicate elements at the same recursive level
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }

            // Make a choice
            currentCombination.add(candidates[i]);
            
            // Recurse to the next element (i + 1 ensures each number is used only once)
            backtrack(results, currentCombination, candidates, remain - candidates[i], i + 1);
            
            // Undo the choice (backtrack)
            currentCombination.remove(currentCombination.size() - 1);
        }
    }
}
