class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int n = nums.length;
        int[] cnt = new int[n + 1];
        cnt[0] = 1;            // Base case: zero odds before starting
        int ans = 0, oddCount = 0;

        for (int v : nums) {
            oddCount += v & 1; // +1 if v is odd

            // If we have at least k odds so far, there are cnt[oddCount - k] subarrays ending here
            if (oddCount - k >= 0) {
                ans += cnt[oddCount - k];
            }

            cnt[oddCount]++;    // Record this oddCount prefix
        }

        return ans;
    }
}
