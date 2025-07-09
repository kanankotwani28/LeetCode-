class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int ans [] = new int[nums1.length];
        Stack < Integer > st = new Stack < > ();  
        HashMap <Integer,Integer> great = new HashMap<>();  
        
        for(int num = nums2.length-1 ; num >=0 ;num --)
        {
            while(!st.empty() && st.peek()<nums2[num])
            {
                st.pop();
            }
            if(!st.isEmpty()) {
                great.put(nums2[num], st.peek());
            } else {
                great.put(nums2[num], -1);
            }
            st.push(nums2[num]);
        }

        for(int i =0 ;i<nums1.length;i++)
        {
            ans[i] = great.getOrDefault(nums1[i],-1);
        }
        return ans;
    }
}