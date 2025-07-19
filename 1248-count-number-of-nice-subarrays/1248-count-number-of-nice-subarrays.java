class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        if (goal < 0) return 0;
        return atMost(nums, goal) - atMost(nums, goal - 1);
    }

    public int atMost(int[] nums, int goal) {
        int left = 0, sum = 0, count = 0;
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];                 
            while (sum > goal) {
                sum -= nums[left++];
            }
            count += right - left + 1;
        }
        return count;
    }
}
