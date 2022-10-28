import java.util.*;

public class SeptemberTwenty {

//    public int largestRectangleArea(int[] heights) {
//        int len = heights.length;
//        if (len == 0) {
//            return 0;
//        }
//
//        if (len == 1) {
//            return heights[0];
//        }
//
//        int res = 0;
//        Deque<Integer> stack = new ArrayDeque<>(len);
//        for (int i = 0; i < len; i++) {
//            while (!stack.isEmpty() && heights[i] < heights[stack.peekLast()]) {
//                int curHeight = heights[stack.pollLast()];
//                while (!stack.isEmpty() && heights[stack.peekLast()] == curHeight) {
//                    stack.pollLast();
//                }
//
//                int curWidth;
//
//            }
//        }
//    }


    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordDist = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDist.contains(s.substring(j,i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

    public static void main(String[] args) {
        System.out.println("1234".substring(0, 0));
    }
}
