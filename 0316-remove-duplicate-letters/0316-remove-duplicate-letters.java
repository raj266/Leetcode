class Solution {
    public String removeDuplicateLetters(String s) {
        int[] lastIndex = new int[26];
        boolean[] seen = new boolean[26];
        Stack<Character> stack = new Stack<>();

        // Record the last index of each character
        for (int i = 0; i < s.length(); i++) {
            lastIndex[s.charAt(i) - 'a'] = i;
        }

        // Traverse the string
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (seen[c - 'a'])
                continue;

            // Ensure characters are in the smallest lexicographical order
            while (!stack.isEmpty() && c < stack.peek() && i < lastIndex[stack.peek() - 'a']) {
                seen[stack.pop() - 'a'] = false;
            }

            stack.push(c);
            seen[c - 'a'] = true;
        }

        // Construct the result
        StringBuilder result = new StringBuilder();
        for (char c : stack) {
            result.append(c);
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        String s1 = "bcabc";
        System.out.println(solution.removeDuplicateLetters(s1)); // Output: "abc"

        String s2 = "cbacdcbc";
        System.out.println(solution.removeDuplicateLetters(s2)); // Output: "acdb"
    }
}