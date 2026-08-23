class Solution {
    public int removeDuplicates(int[] nums) {
    if (nums.length == 0) return 0;
    
    int uniqueIndex = 0; // Tracks the position of unique elements
    
    for (int i = 1; i < nums.length; i++) {
        if (nums[i] != nums[uniqueIndex]) {
            uniqueIndex++;
            nums[uniqueIndex] = nums[i]; // Move unique element forward
        }
    }
    return uniqueIndex + 1; // Returns the new length of unique elements
    }
}