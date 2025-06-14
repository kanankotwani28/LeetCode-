class Solution {
    public int countPart(int nums[],int sum)
    {
        int div = 1;
        int add = 0;
        for(int i = 0;i<nums.length;i++)
        {
            if(nums[i]+add<=sum)
            {
                add+=nums[i];
            }
            else
            {
                div++;
                add=nums[i];
            }
        }
        return div;
    }
    public int splitArray(int[] nums, int k) {

        int low = Integer.MIN_VALUE;
        int high = 0;
        for(int i = 0;i<nums.length;i++)
        {
            low = Math.max(low,nums[i]);
            high+=nums[i];
        }

        while(low<=high)
        {
            int mid = (low+high)/2;
            int noOfPart = countPart(nums,mid);
            if(noOfPart > k)
            {
                low=mid+1;
            }
            else
            {
                high = mid-1;
            }
        }
        return low;   
    }

    
}