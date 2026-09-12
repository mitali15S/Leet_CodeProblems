import java.util.*;

class Solution {
    public List<String> buildArray(int[] target, int n) {
        List<String> operations = new ArrayList<>();
        int j = 0; // pointer for target
        
        for (int i = 1; i <= n && j < target.length; i++) {
            operations.add("Push");
            if (i == target[j]) {
                j++; // keep it
            } else {
                operations.add("Pop"); // discard it
            }
        }
        
        return operations;
    }
}
