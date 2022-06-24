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

}
