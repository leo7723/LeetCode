import java.util.ArrayList;
import java.util.List;

public class JulyTwentyOne {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        res.add(new ArrayList<>());
        part(nums, 0, res, new ArrayList<>());
        return res;
    }

    public void part(int[] nums, int i, List<List<Integer>> res, List<Integer> temp) {
        for (int j = i; j < nums.length; j++) {
            temp.add(nums[j]);
            res.add(new ArrayList<>(temp));
            part(nums, j+1, res, temp);
            temp.remove(temp.size()-1);
        }
    }

    public static void main(String[] args) {
        new JulyTwentyOne().subsets(new int[]{1,2,3});
    }

    public boolean exist(char[][] board, String word) {
        int h = board.length, w = board[0].length;
        boolean[][] visited = new boolean[h][w];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (check(visited, board, i, j, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean check(boolean[][] visited, char[][] board, int i, int j, String word, int k) {
        if (board[i][j] != word.charAt(k)) {
            return false;
        } else if (k == word.length() -1) {
            return true;
        }

        visited[i][j] = true;
        int[][] direction = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        for (int[] dir: direction) {
            int newi = i+dir[0];
            int newj = j + dir[1];
            if (newi>=0 && newj >=0 && newj < board[0].length && newi<board.length) {
                if (!visited[newi][newj] && check(visited, board, newi, newj, word, k+1)) {
                    visited[i][j] = false;
                    return true;
                }
            }
        }
        visited[i][j] = false;
        return false;
    }
}
