class Solution {
    public static boolean isCircularSentence(String sentence) {
        String[] words = sentence.split(" ");
        for (int i = 0; i < words.length; i++) {
            char lastChar = words[i].charAt(words[i].length() - 1);
            char firstChar = words[(i + 1) % words.length].charAt(0);
            if (lastChar != firstChar) {
                return false;
            }
        }
        return true;
    }

}