class Solution {
    public int takeCharacters(String s, int k) {
        int[] count = new int[3];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }

        if (Math.min(Math.min(count[0], count[1]), count[2]) < k) {
            return -1;
        }

        int res = Integer.MAX_VALUE;
        int l = 0;
        for (int r = 0; r < s.length(); r++) {
            count[s.charAt(r) - 'a']--;

            while (Math.min(Math.min(count[0], count[1]), count[2]) < k) {
                count[s.charAt(l) - 'a']++;
                l++;
            }
            res = Math.min(res, s.length() - (r - l + 1));
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        String s1 = "aabaaaacaabc";
        int k1 = 2;
        System.out.println(solution.takeCharacters(s1, k1)); // Output: 8

        String s2 = "a";
        int k2 = 1;
        System.out.println(solution.takeCharacters(s2, k2)); // Output: -1
    }

}