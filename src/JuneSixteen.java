import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class JuneSixteen {
    public static void main(String[] args) {
        new JuneSixteen().merge(new int[][]{{1,3},{2,6},{8,10},{15,18}});
    }

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (v1,v2)-> v1[0] - v2[0]);
        int [][] res = new int[intervals.length][2];
        int idx = -1;
        for (int[] interval : intervals) {

            if (idx == -1 || interval[0] > res[idx][1]) {
                res[++idx] = interval;
            }else {
                // 反之说明重叠，则将当前区间合并至结果数组的最后区间
                res[idx][1] = Math.max(res[idx][1], interval[1]);
            }

        }
        return Arrays.copyOf(res, idx + 1);
    }

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (hashMap.containsKey(nums[i])) {
                return new int[]{hashMap.get(nums[i]), i};
            }
            hashMap.put(target - nums[i], i);
        }
        return new int[2];
    }
}
