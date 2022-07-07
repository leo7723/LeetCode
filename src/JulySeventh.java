public class JulySeventh {
    public int[] searchRange(int[] nums, int target) {
        int l = 0, r = nums.length - 1,n = 0;
        while (l <= r) {
            n = l + (r-l)/2;
            if (nums[n] == target) break;
            if (nums[n] > target) {
                r = n-1;
            } else {
                l = n+1;
            }
        }

        if (l>=r) {
            return new int[]{-1,-1};
        }

        int start = n;
        while (start-1 >= 0) {
            if (nums[start-1] != target) break;
            start--;
        }
        int end = n;
        while (end + 1 < nums.length-1) {
            if (nums[end + 1] != target) break;
            end++;
        }
        return new int[]{start, end};
    }
}
