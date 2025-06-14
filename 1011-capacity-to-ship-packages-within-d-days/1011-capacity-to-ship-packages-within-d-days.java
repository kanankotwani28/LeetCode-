class Solution {
    public int noOfDays(int []weights , int cap)
    {
        int day = 1;
        int load = 0;

        for(int i = 0 ; i<weights.length ;i++)
        {
            if(weights[i]+load > cap )
            {
                day++;
                load = weights[i];
            }
            else
            {
                load+=weights[i];
            }
        }

        return day;
    }
    public int shipWithinDays(int[] weights, int days) {

        int low = Integer.MIN_VALUE;
        int high = 0;
        for(int i = 0;i<weights.length;i++)
        {
            low = Math.max(weights[i],low);
            high += weights[i];
        }

       while(low<=high)
       {
         int mid = (low+high)/2;

         if(noOfDays(weights,mid)<=days)
         {
            high = mid-1;
         }
         else
         {
            low = mid+1;
         }
       }

       return low;
         
    }
}