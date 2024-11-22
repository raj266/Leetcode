class Solution {
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        Map<String, Integer> pattern = new HashMap<>();
        for(int[] row: matrix){
            StringBuilder normal = new StringBuilder();
            StringBuilder flipped = new StringBuilder();
            for(int cell: row){
                normal.append(cell);
                flipped.append(cell^1); //XOR with 1
            }
            String normalStr =  normal.toString();
            String flippedStr = flipped.toString();
            pattern.put(normalStr, pattern.getOrDefault(normalStr, 0)+1);
            pattern.put(flippedStr, pattern.getOrDefault(flippedStr, 0) +1 );
        }
        int maxCount=0;
        for(int count: pattern.values()){
            maxCount = Math.max(maxCount, count);
        }
        return maxCount;
    }

}