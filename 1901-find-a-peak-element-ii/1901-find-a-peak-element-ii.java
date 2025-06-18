class Solution {
    public int maxRow( int[][] mat , int n,int m ,int mid)
    {
        int maxi = -1 , index = -1;
        for(int i = 0 ;i<n;i++)
        {
            if(mat[i][mid]>maxi)
            {
                maxi=mat[i][mid];
                index=i;
            }
        }
        return index;
    }
    public int[] findPeakGrid(int[][] mat) {

        int n = mat.length;
        int m = mat[0].length;

        int low = 0 , high = m-1;
        while(low<=high)
        {
            int mid = (low+high)/2;
            int maxRowEl = maxRow(mat,n,m,mid);
            int left = mid-1>=0 ? mat[maxRowEl][mid-1] : -1;
            int right = mid+1 < m ? mat[maxRowEl][mid+1] : -1;

            if(left < mat[maxRowEl][mid] && right < mat[maxRowEl][mid])
            {
                return new int[]{maxRowEl,mid};
            }
            else if(left > mat[maxRowEl][mid])
            {
                high = mid-1;
            }
            else
            {
                low=mid+1;
            }

        }
        return new int[]{-1,-1};
        
        
    }
}