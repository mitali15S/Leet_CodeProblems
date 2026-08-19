class Solution {
    

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int ans = 0;
        int minDiff  = Integer.MAX_VALUE;

        for(int i = 0; i<nums.length-2; i++){
            int left = i+1;
            int right = nums.length-1;

            if(i > 0 && nums[i] == nums[i-1]) continue;

            while(left < right){
                int sum = nums[i] + nums[left] + nums[right];
                int diff = Math.abs(target - sum);
                if(sum == target){
                    return sum;
                }
                else if(sum < target){
                    if(diff < minDiff){
                        minDiff = diff;
                        ans = sum;
                    }
                    left++;
                    while(left <  right && nums[left] == nums[left - 1]){
                        left++;
                    }
                }else{
                    if(diff < minDiff){
                        minDiff = diff;
                        ans = sum;
                    }

                    right--;
                    while(left < right && nums[right] == nums[right + 1]){
                        right--;
                    }
                }
            }
        }

        return ans;
    }
}