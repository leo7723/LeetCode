import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class JuneTwentyFifth {
    public int reverse(int x) {
        int res = 0;
        while (x != 0) {
            if (res > Integer.MAX_VALUE/10 || res < Integer.MIN_VALUE / 10) {
                return 0;
            }
            res = res*10+ x%10;
            x = x/10;
        }
        return res;
    }

    public int maxArea(int[] height) {
        int i = 0, j = height.length-1;
        int max = 0;
        while (i < j) {
            int temp = (j-i) * Math.min(height[i],height[j]);
            max = Math.max(temp, max);
            if (height[i] <= height[j]) {
                i++;
            } else {
                j--;
            }
        }
        return max;
    }
}
