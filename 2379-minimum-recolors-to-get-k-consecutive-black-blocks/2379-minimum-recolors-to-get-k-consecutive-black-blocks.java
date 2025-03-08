class Solution {
    public static int minimumRecolors(String blocks, int k) {
        int n = blocks.length();
        int minOps = Integer.MAX_VALUE;

        for (int i = 0; i <= n - k; i++) {
            int ops = 0;
            for (int j = i; j < i + k; j++) {
                if (blocks.charAt(j) == 'W') {
                    ops++;
                }
            }
            minOps = Math.min(minOps, ops);
        }

        return minOps;
    }
}