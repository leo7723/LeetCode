import java.util.ArrayList;
import java.util.List;

public class JulyTenth {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null || nums.length == 0) return ans;
        part(new ArrayList<>(), ans, nums, new boolean[nums.length]);
        return ans;
    }

    public void part(List<Integer> list, List<List<Integer>> ans, int[] nums, boolean[] used) {
        if (list.size() == nums.length) {
            ans.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            list.add(nums[i]);
            used[i] = true;
            part(list, ans, nums, used);
            list.remove(list.size()-1);
            used[i] = false;
        }
    }

    /**
     * 第一行变成倒数第一列
     * matrix[row][col] = matrix[col][n - row - 1]
     *
     * @param matrix
     */
    public void rotate(int[][] matrix) {
        if (matrix.length == 0 || matrix.length != matrix[0].length) {
            return;
        }

        int nums = matrix.length;
        for (int i = 0; i < nums/2; i++) {
            for (int j = 0; j < nums; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[nums-i-1][j];
                matrix[nums-i-1][j] = temp;
            }
        }

        for (int i = 0; i < nums; i++) {
            for (int j = 0; j < i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
}
