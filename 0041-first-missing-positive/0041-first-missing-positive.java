class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;

        // Step 1: Cyclic Sort - Place each number in its correct index if possible
        for (int i = 0; i < n; i++) {
            // Keep swapping until the current element is in its correct place,
            // or it's out of the valid range [1, n], or it's a duplicate.
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                // Swap nums[i] with the element at its target index (nums[i] - 1)
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }

        // Step 2: Find the first index where the number doesn't match the index + 1
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1; // This is the smallest missing positive
            }
        }

        // Step 3: If all numbers 1 to n are present, the missing one is n + 1
        return n + 1;
            }
}
