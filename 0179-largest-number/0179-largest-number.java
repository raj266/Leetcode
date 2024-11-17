class Solution {
    public String largestNumber(int[] nums) {
        String[] strNums = new String[nums.length];

        // Convert integer array to string array
        for (int i = 0; i < nums.length; i++) {
            strNums[i] = String.valueOf(nums[i]);
        }

        // Sort the array based on the custom comparator
        Arrays.sort(strNums, (a, b) -> (b + a).compareTo(a + b));

        // Edge case: If the largest number is 0, just return "0"
        if (strNums[0].equals("0")) {
            return "0";
        }

        // Concatenate the numbers to form the largest number
        StringBuilder largestNumber = new StringBuilder();
        for (String num : strNums) {
            largestNumber.append(num);
        }

        return largestNumber.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums1 = { 10, 2 };
        System.out.println(solution.largestNumber(nums1)); // Output: "210"

        int[] nums2 = { 3, 30, 34, 5, 9 };
        System.out.println(solution.largestNumber(nums2)); // Output: "9534330"
    }

}