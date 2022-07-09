public class JulyNinth {
    public int trap(int[] height) {
        int ans = 0;
        int left = 0, right = height.length - 1;
        int maxLeft = 0, maxRight = 0;
        while (left < right) {
            maxLeft = Math.max(height[left], maxLeft);
            maxRight = Math.max(height[right], maxRight);
            if (maxLeft < maxRight) {
                ans += maxLeft - height[left];
                left++;
            } else {
                ans += maxRight - height[right];
                right--;
            }
        }
        return ans;
    }
}
