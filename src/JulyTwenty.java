public class JulyTwenty {
    public void sortColors(int[] nums) {
        int i = 0, j = 0, k = nums.length - 1;
        int temp = 0;
        while (j <= k) {
            if (nums[j] == 0) {
                temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
                j++;
            } else if (nums[j] == 2) {
                temp = nums[k];
                nums[k] = nums[j];
                nums[j] = temp;
                k--;
            } else {
                j++;
            }

        }
    }
}
