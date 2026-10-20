class Solution {
    public boolean search(int[] nums, int target) {
        for (int i = 0; i <= nums.length - 1; i++) {
            if (nums[i] == target) {
                return true;
            }
        }
        return false;
    }
}