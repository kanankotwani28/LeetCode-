class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int lsum = 0;
        int rsum = 0;
        int n = cardPoints.length;
        int risum = n-1;
        int maxSum = 0;

        for(int i=0 ;i<=k-1;i++)
        {
            lsum+=cardPoints[i];
        }
        maxSum=lsum;
        for(int i=k-1;i>=0;i--)
        {
            lsum-=cardPoints[i];
            rsum+=cardPoints[risum];
            maxSum = Math.max(maxSum,lsum+rsum);
            risum--;
        }
        return maxSum;
    }
}