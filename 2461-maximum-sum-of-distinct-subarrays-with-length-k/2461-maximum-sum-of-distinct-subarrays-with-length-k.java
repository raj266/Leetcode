class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        long currSum = 0;
        long ans = 0;
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < k; i++) {
            currSum += (long)nums[i];
            map.put(nums[i], map.getOrDefault(nums[i],0) + 1);

        }
        if(map.size() == k) {
            ans = currSum;
        }

        int left = 0;
        for(int i = k; i < n; i++) {
            currSum -= (long)nums[left];
            currSum += (long)nums[i];
            map.put(nums[left], map.get(nums[left]) - 1);
            if(map.get(nums[left]) == 0) {
                map.remove(nums[left]);
            }
            map.put(nums[i], map.getOrDefault(nums[i],0) + 1);
            if(map.size() == k) {
                ans = Math.max(currSum, ans);
            }
            left++;
        }
        return ans;
    }
}