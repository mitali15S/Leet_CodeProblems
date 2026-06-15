class Solution {
    public int maxArea(int[] height) {
        int max = 0;
        int left = 0;
        int right = height.length - 1;
        while(left < right){
            int width = right - left;
            int current = Math.min(height[left],height[right]);
            int currentwater = width * current;
            max = Math.max(max,currentwater);

            if(height[left] < height[right]){
                left++;
            }
            else{
                right--;
            }
        }
        return max;
    }
}