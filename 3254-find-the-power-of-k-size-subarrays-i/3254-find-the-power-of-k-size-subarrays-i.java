class Solution {
    public int[] resultsArray(int[] nums, int k) {
        int n = nums.length;
        int[] result = new int[n - k + 1];
        
        for (int i = 0; i <= n - k; i++) {
            int maxElement = Integer.MIN_VALUE;
            boolean isConsecutiveAndSorted = true;
            
            for (int j = 0; j < k; j++) {
                if (j > 0 && nums[i + j] != nums[i + j - 1] + 1) {
                    isConsecutiveAndSorted = false;
                    break;
                }
                maxElement = Math.max(maxElement, nums[i + j]);
            }
            
            result[i] = isConsecutiveAndSorted ? maxElement : -1;
        }
        
        return result;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums1 = {1, 2, 3, 4, 3, 2, 5};
        int k1 = 3;
        System.out.println(Arrays.toString(sol.resultsArray(nums1, k1))); // Output: [3, 4, -1, -1, -1]
        
        int[] nums2 = {2, 2, 2, 2, 2};
        int k2 = 4;
        System.out.println(Arrays.toString(sol.resultsArray(nums2, k2))); // Output: [-1, -1]
        
        int[] nums3 = {3, 2, 3, 2, 3, 2};
        int k3 = 2;
        System.out.println(Arrays.toString(sol.resultsArray(nums3, k3))); // Output: [-1, 3, -1, 3, -1]
    }
}