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
}
