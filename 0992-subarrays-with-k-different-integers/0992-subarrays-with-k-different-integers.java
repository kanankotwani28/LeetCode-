class Solution {
    public int subarraysWithKDistinct(int[] nums, int K) {
        return atMostK(nums, K) - atMostK(nums, K - 1);
    }
    
    private int atMostK(int[] nums, int K) {
        int res = 0;
        int[] count = new int[nums.length + 1];
        int distinct = 0;
        int left = 0;
        
        for (int right = 0; right < nums.length; right++) {
            if (count[nums[right]]++ == 0) distinct++;
            
            while (distinct > K) {
                if (--count[nums[left]] == 0) distinct--;
                left++;
            }
            
            res += right - left + 1;  
        }
        
        return res;
    }
}
