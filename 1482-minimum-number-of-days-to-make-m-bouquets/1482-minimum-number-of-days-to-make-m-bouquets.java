class Solution {
    public boolean possible(int arr[],int day,int m,int k)
    {
        int n = arr.length;
        int cnt = 0;
        int boq = 0;

        for(int i = 0;i<n;i++)
        {
            if(arr[i]<=day)
            {
                cnt++;
            }
            else{
                boq+=(cnt/k);
                cnt=0;
            }
        }
        boq+=(cnt/k);
        return boq>=m;
    }
    public int minDays(int[] bloomDay, int m, int k) {

        if((long)m*k> bloomDay.length) 
            return -1;

        int mini = Integer.MAX_VALUE;
        int maxi = Integer.MIN_VALUE;
        for(int i = 0 ; i<bloomDay.length;i++)
        {
            maxi = Math.max(maxi,bloomDay[i]);
            mini = Math.min(mini,bloomDay[i]);
        }
        
        int low = mini , high = maxi ;
        while(low<=high)
        {
            int mid=(low+high)/2;
             if(possible(bloomDay,mid,m,k))
             {
                high = mid-1;
             }
             else{
                low = mid+1;
             }
        }
        return low;
    }
}