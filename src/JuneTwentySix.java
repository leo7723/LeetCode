import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JuneTwentySix {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return result;
        }

        Arrays.sort(nums);
        for (int i = 0; i < nums.length-2; i++) {
            if (nums[i] > 0) break;
            if (i> 0 && nums[i] == nums[i-1]) continue;

            int n = i+1,m = nums.length - 1, target = -nums[i];
            while (n < m) {
                if (nums[n] + nums[m] == target) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[n]);
                    temp.add(nums[m]);
                    result.add(temp);
                    n++;
                    m--;
                    while (n < m && nums[n] == nums[n-1]) n++;
                    while (n < m && nums[m] == nums[m+1]) m--;
                } else if (nums[n] + nums[m] < target) {
                    n++;
                } else {
                    m--;
                }
            }
        }
        return result;
    }
}
