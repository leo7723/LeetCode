package twentytwentythree;

public class JuneFifteen {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        if (k == 0) {
            return;
        }
        part(nums, 0, nums.length - 1);
        part(nums, 0, k-1);
        part(nums, k, nums.length -1);
    }

    private void part(int[] nums, int i, int j){
        int temp = 0;
        while (i<=j) {
            temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }
}
