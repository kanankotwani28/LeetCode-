class Solution {
    public int sum(int nums[],int div)
    {
        int n = nums.length;
        int sum = 0;
        for(int i = 0 ;i<n;i++)
        {
            sum+=Math.ceil((double)nums[i]/(double)div);
        }
        return sum;
    }
    public int smallestDivisor(int[] nums, int threshold) {
        int n = nums.length;

        if(n>threshold) return -1;
        int maxi = Integer.MIN_VALUE;

        for(int i = 0;i<n;i++)
        {
            maxi = Math.max(maxi,nums[i]);
        }

        int low = 1,high = maxi;
        while(low<=high)
        {
            int mid =(low+high)/2;
            if(sum(nums,mid) <= threshold)
            {
                high = mid-1;
            }
            else
            {
                low=mid+1;
            }
        }
        return low;
        

        
    }
}