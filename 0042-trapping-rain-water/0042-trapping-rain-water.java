class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int left = 0,right = n-1;
        int total = 0;
        int Lmax = 0,Rmax=0;
        while(left<=right)
        {
            if(height[left]<=height[right])
            {
                if(height[left]<Lmax)
                {
                    total+=Lmax-height[left];
                }
                else
                {
                    Lmax = height[left];
                }
                left++;
            }
            else
            {
                if(height[right]<Rmax)
                {
                    total+=Rmax-height[right];
                }
                else
                {
                    Rmax = height[right];
                }
                right--;
            }
        }
        return total;
    }
}