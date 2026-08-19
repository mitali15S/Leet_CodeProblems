class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        
        List<List<Integer>> result = new ArrayList<>();

        // Base case check
        if (nums == null || nums.length < 4) {
            return result;
        }

        // Sort to use two-pointer method and easily skip duplicates
        Arrays.sort(nums);
        int n = nums.length;

        // First element loop
        for (int i = 0; i < n - 3; i++) {
            // Skip duplicate values for the first element
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            // Optimization: Smallest possible sum exceeds target
            if ((long) nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) break;
            // Optimization: Largest possible sum with current element is smaller than target
            if ((long) nums[i] + nums[n - 3] + nums[n - 2] + nums[n - 1] < target) continue;

            // Second element loop
            for (int j = i + 1; j < n - 2; j++) {
                // Skip duplicate values for the second element
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;

                // Optimization: Smallest possible sum with fixed i and j exceeds target
                if ((long) nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target) break;
                // Optimization: Largest possible sum with fixed i and j is smaller than target
                if ((long) nums[i] + nums[j] + nums[n - 2] + nums[n - 1] < target) continue;

                // Two-pointer pointers for the last two elements
                int k = j + 1;
                int l = n - 1;

                while (k < l) {
                    long sum = (long) nums[i] + nums[j] + nums[k] + nums[l];

                    if (sum == target) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));

                        // Skip duplicate values for the third element
                        while (k < l && nums[k] == nums[k + 1]) k++;
                        // Skip duplicate values for the fourth element
                        while (k < l && nums[l] == nums[l - 1]) l--;

                        k++;
                        l--;
                    } else if (sum < target) {
                        k++; // Sum too small, move left pointer forward
                    } else {
                        l--; // Sum too large, move right pointer backward
                    }
                }
            }
        }

        return result;
    }
}