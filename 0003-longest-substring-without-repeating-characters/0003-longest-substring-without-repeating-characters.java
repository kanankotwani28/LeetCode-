class Solution {
    public int lengthOfLongestSubstring(String s) {

        if(s.length()==0)
            return 0;
        int max = Integer.MIN_VALUE;
        int hash[] = new int[256];
        Arrays.fill(hash, -1);
        int l = 0, r= 0;

        int n = s.length();
        while(r<n)
        {
            if(hash[s.charAt(r)]!=-1)
            {
                if(hash[s.charAt(r)]>=l)
                {
                    l = hash[s.charAt(r)]+1;
                }
            }
            max = Math.max(max,r-l+1);
            hash[s.charAt(r)]=r;
            r++; 
        }
         
        return max;
    }
}