import java.util.*;

class Solution {
    private static class Node {
        String state;
        int zeroIndex;
        int steps;

        Node(String state, int zeroIndex, int steps) {
            this.state = state;
            this.zeroIndex = zeroIndex;
            this.steps = steps;
        }
    }

    public int slidingPuzzle(int[][] board) {
        String target = "123450";
        StringBuilder start = new StringBuilder();
        for (int[] row : board) {
            for (int num : row) {
                start.append(num);
            }
        }

        if (start.toString().equals(target)) return 0;

        int[][] moves = {{1, 3}, {0, 2, 4}, {1, 5}, {0, 4}, {1, 3, 5}, {2, 4}};
        Set<String> visited = new HashSet<>();
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(start.toString(), start.indexOf("0"), 0));
        visited.add(start.toString());

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            for (int move : moves[current.zeroIndex]) {
                String nextState = swap(current.state, current.zeroIndex, move);
                if (nextState.equals(target)) {
                    return current.steps + 1;
                }
                if (!visited.contains(nextState)) {
                    queue.offer(new Node(nextState, move, current.steps + 1));
                    visited.add(nextState);
                }
            }
        }
        return -1;
    }

    private String swap(String state, int i, int j) {
        char[] chars = state.toCharArray();
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
        return new String(chars);
    }
}