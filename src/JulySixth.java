public class JulySixth {
    /**
     * dp[i] = dp[i-1] + 2
     * dp[i] = dp[i-1] + 2 + dp[i - dp[i-1] - 2]
     * @param s
     * @return
     */
    public int longestValidParentheses(String s) {
        int maxans = 0;
        int [] dp = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i) == '(') {
                    dp[i] = (i >= 2 ? dp[i-2] : 0) + 2;
                } else if (i-dp[i-1] > 0 && s.charAt(i-dp[i-1]-1) == '(') {
                    dp[i] = dp[i-1] + ((i - dp[i-1]) >= 2? dp[i-dp[i-1]-2] : 0) +2;
                }
                maxans = Math.max(maxans, dp[i]);
            }
        }
        return maxans;
    }

    /**
     * i+j/2 = n

     * nums[n] < nmus[j] 落在右边 i n 无序 n j 递增
     * target > nums[n] < nums[j] 取 n+1 j  不然i n-1
     * nums[n] > nmus[j] 落在左边 i n 递增 n j 无序 target > nums[i] < nums[n]
     * target > nums[i] < nums[n] 取 i n-1  不然 n+1 j
     *
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        if (nums.length == 1 && nums[0] == target) {
            return 0;
        }

        int i = 0 , j = nums.length - 1;
        while (i <= j) {
            int n = (i+j)/2;
            if (nums[n] == target) return n;
            if (nums[n] < nums[nums.length-1]) {
                if (target > nums[n] && target <= nums[j]) {
                    i = n+1;
                } else {
                    j = n-1;
                }
            } else {
                if (target >= nums[i] && target < nums[n]) {
                    j = n- 1;
                } else {
                    i = n+1;
                }
            }
        }
        return -1;
    }
}
