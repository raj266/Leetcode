class Solution {
    public int shortestSubarray(int[] nums, int k) {
         int n = nums.length;
        long[] prefixSums = new long[n + 1];
        
        // Compute prefix sums
        for (int i = 0; i < n; i++) {
            prefixSums[i + 1] = prefixSums[i] + nums[i];
        }
        
        // Deque to store the indices of the prefix sums
        Deque<Integer> deque = new LinkedList<>();
        int minLength = n + 1;
        
        for (int i = 0; i <= n; i++) {
            // Maintain the deque and find the shortest subarray
            while (!deque.isEmpty() && prefixSums[i] - prefixSums[deque.peekFirst()] >= k) {
                minLength = Math.min(minLength, i - deque.pollFirst());
            }
            // Maintain monotonicity in the deque
            while (!deque.isEmpty() && prefixSums[i] <= prefixSums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offerLast(i);
        }
        
        return minLength <= n ? minLength : -1;
    }
}