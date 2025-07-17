import java.util.Arrays;

class Solution {
    public int characterReplacement(String s, int k) {
        int left = 0, right = 0, maxLen = 0, maxf = 0;
        int n = s.length();
        int[] hash = new int[26];
        Arrays.fill(hash, 0);

        while (right < n) {
            int index = s.charAt(right) - 'A';
            hash[index]++;
            maxf = Math.max(maxf, hash[index]);

            if ((right - left + 1) - maxf > k) {
                hash[s.charAt(left) - 'A']--;
                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
            right++;
        }

        return maxLen;
    }
}
