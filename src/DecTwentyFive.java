public class DecTwentyFive {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int i = 0;
        int j = matrix.length - 1;
        while (i < matrix[0].length && j >= 0) {
            if (matrix[j][i] == target) {
                return true;
            } else if (target < matrix[j][i]) {
                j --;
            } else {
                i++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        new DecTwentyFive().searchMatrix(new int[][]{{1,1}}, 2);
    }
}
