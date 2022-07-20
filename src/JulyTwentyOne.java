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
}
