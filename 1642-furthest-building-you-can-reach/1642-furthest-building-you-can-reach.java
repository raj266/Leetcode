class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
       PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> b - a);
        int n = heights.length;

        for (int i = 0; i < n - 1; i++) {
            int diff = heights[i + 1] - heights[i];
            if (diff > 0) {
                heap.add(diff);
                bricks -= diff;

                if (bricks < 0) {
                    if (ladders > 0) {
                        bricks += heap.poll();
                        ladders--;
                    } else {
                        return i;
                    }
                }
            }
        }

        return n - 1;
    }
}