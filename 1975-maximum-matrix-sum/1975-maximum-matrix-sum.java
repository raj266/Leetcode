class Solution {
    public static int maxMatrixSum(int[][] matrix) {
          int n = matrix.length;
        int sum = 0;
        int negativeCount = 0;
        int minAbsValue = Integer.MAX_VALUE;
        
        // Calculate initial sum and count negative numbers
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int value = matrix[i][j];
                sum += Math.abs(value);
                if (value < 0) {
                    negativeCount++;
                }
                minAbsValue = Math.min(minAbsValue, Math.abs(value));
            }
        }

        // If the count of negative numbers is odd, subtract twice the smallest absolute value
        if (negativeCount % 2 != 0) {
            sum -= 2 * minAbsValue;
        }

        return sum;
    }
}