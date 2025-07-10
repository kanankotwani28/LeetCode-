class Solution {
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        int mod = (int)1e9 + 7;
        
        int[] left = new int[n];
        int[] right = new int[n];
        
        Stack<int[]> stack = new Stack<>();
        
        // Calculate left counts
        for (int i = 0; i < n; i++) {
            int count = 1;
            while (!stack.isEmpty() && stack.peek()[0] > arr[i]) {
                count += stack.pop()[1];
            }
            left[i] = count;
            stack.push(new int[]{arr[i], count});
        }
        
        stack.clear();
        
        // Calculate right counts
        for (int i = n - 1; i >= 0; i--) {
            int count = 1;
            while (!stack.isEmpty() && stack.peek()[0] >= arr[i]) {
                count += stack.pop()[1];
            }
            right[i] = count;
            stack.push(new int[]{arr[i], count});
        }
        
        long result = 0;
        for (int i = 0; i < n; i++) {
            result = (result + (long)arr[i] * left[i] * right[i]) % mod;
        }
        
        return (int)result;
    }
}
