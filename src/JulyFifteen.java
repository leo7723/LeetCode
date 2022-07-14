import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class JulyFifteen {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        List<int []> result = new ArrayList<>();
        int left = intervals[0][0], right = intervals[0][1];
        for (int[] array: intervals) {
            if (array[0] > right) {
                result.add(new int[]{left, right});
                left = array[0];
                right = array[1];
            } else {
                right = Math.max(right, array[1]);
            }
        }
        result.add(new int[]{left, right});
        return result.toArray(new int[][]{});
    }
}
