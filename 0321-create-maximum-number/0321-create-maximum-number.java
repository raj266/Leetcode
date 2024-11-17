class Solution {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int m = nums1.length, n = nums2.length;
        int[] maxSequence = new int[k];

        // Iterate through all possible lengths for the first subsequence
        for (int i = Math.max(0, k - n); i <= Math.min(k, m); i++) {
            int[] subsequence1 = maxSubsequence(nums1, i);
            int[] subsequence2 = maxSubsequence(nums2, k - i);
            int[] candidate = merge(subsequence1, subsequence2, k);
            if (greater(candidate, 0, maxSequence, 0)) {
                maxSequence = candidate;
            }
        }

        return maxSequence;
    }

    private int[] maxSubsequence(int[] nums, int k) {
        int n = nums.length;
        int[] stack = new int[k];
        int top = -1, remaining = n - k;
        for (int num : nums) {
            while (top >= 0 && stack[top] < num && remaining > 0) {
                top--;
                remaining--;
            }
            if (top < k - 1) {
                stack[++top] = num;
            } else {
                remaining--;
            }
        }
        return stack;
    }

    private int[] merge(int[] nums1, int[] nums2, int k) {
        int[] merged = new int[k];
        int i = 0, j = 0, r = 0;
        while (r < k) {
            if (greater(nums1, i, nums2, j)) {
                merged[r++] = nums1[i++];
            } else {
                merged[r++] = nums2[j++];
            }
        }
        return merged;
    }

    private boolean greater(int[] nums1, int i, int[] nums2, int j) {
        while (i < nums1.length && j < nums2.length && nums1[i] == nums2[j]) {
            i++;
            j++;
        }
        return j == nums2.length || (i < nums1.length && nums1[i] > nums2[j]);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums1 = { 3, 4, 6, 5 };
        int[] nums2 = { 9, 1, 2, 5, 8, 3 };
        int k1 = 5;
        System.out.println(Arrays.toString(solution.maxNumber(nums1, nums2, k1))); // Output: [9, 8, 6, 5, 3]

        int[] nums3 = { 6, 7 };
        int[] nums4 = { 6, 0, 4 };
        int k2 = 5;
        System.out.println(Arrays.toString(solution.maxNumber(nums3, nums4, k2))); // Output: [6, 7, 6, 0, 4]

        int[] nums5 = { 3, 9 };
        int[] nums6 = { 8, 9 };
        int k3 = 3;
        System.out.println(Arrays.toString(solution.maxNumber(nums5, nums6, k3))); // Output: [9, 8, 9]
    }

}