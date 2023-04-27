package twentytwentythree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AprilTwentySeven {
    public void moveZeroes(int[] nums) {
        if (nums == null) {
            return;
        }
        int q = 0;
        for (int p = 0; p < nums.length; p++) {
            if (nums[p] != 0) {
                int temp = nums[p];
                nums[p] = nums[q];
                nums[q++] = temp;
            }
        }
    }

    public int maxArea(int[] height) {
        int i = 0, j = height.length - 1;

        int result = 0;
        while (i < j) {
            result = Math.max(Math.min(height[i], height[j]) * (j-i), result);
            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }
        return result;
    }

    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 3) {
            return new ArrayList<>();
        }

        ArrayList<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length-2; i++) {
            if (i != 0 && nums[i] == nums[i-1]) {
                continue;
            }
            if (nums[i] > 0) {
                break;
            }
            int p = i+1;
            int q = nums.length - 1;
            while (p < q) {
                if (nums[i] + nums[p] + nums[q] > 0) {
                    q -- ;
                } else if (nums[i] + nums[p] + nums[q] < 0) {
                    p++;
                } else {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[q]);
                    list.add(nums[p]);
                    result.add(list);
                    while (p < q && nums[p] == nums[p+1])
                        p++;
                    while (p < q && nums[q] == nums[q-1])
                        q--;
                    p++;
                    q--;
                }
            }
        }
        return result;
    }
}
