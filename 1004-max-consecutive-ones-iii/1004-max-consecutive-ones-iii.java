class Solution {
    public int longestOnes(int[] nums, int k) {

       int left = 0 , right = 0;
       int zeros = 0 , maxLen = 0;
       int n = nums.length;

       while(right<n)
       {
            if(nums[right]==0)
                zeros++;
            if(zeros>k)
            {
                if(nums[left]==0)
                    zeros--;
                left++;
            }
            else if(zeros<=k)
            {
                maxLen=Math.max(maxLen,right-left+1);
            }
            right++;
       }  
       return maxLen; 
    }
}