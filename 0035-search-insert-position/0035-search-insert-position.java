class Solution {
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length;  // right is exclusive

        while (left < right) {
            int mid = (left + right) >>> 1;  // Prevents overflow
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;  // Insertion point if target not found
    }
}
