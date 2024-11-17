class Solution {
    public int candy(int[] ratings) {
     int n = ratings.length;
        int[] candies = new int[n];

        // Initialize all children with at least one candy
        Arrays.fill(candies, 1);

        // Left to right pass
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            }
        }

        // Right to left pass
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
            }
        }

        // Calculate the total number of candies
        int totalCandies = 0;
        for (int candy : candies) {
            totalCandies += candy;
        }

        return totalCandies;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] ratings1 = {1, 0, 2};
        System.out.println(solution.candy(ratings1)); // Output: 5

        int[] ratings2 = {1, 2, 2};
        System.out.println(solution.candy(ratings2)); // Output: 4
    }
}