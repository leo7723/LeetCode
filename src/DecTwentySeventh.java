import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DecTwentySeventh {
    public int numSquares(int n) {
        List<Integer> list = new ArrayList<>();
        int t = 1;
        while (t*t <= n) {
            list.add(t*t);
            t++;
        }

        int m = list.size();
        int[][] f = new int[m+1][n+1];

        Arrays.fill(f[0], 0x3f3f3f3f);
        f[0][0] = 0;

        for (int i = 1; i <= m; i++) {
            int x = list.get(i-1);
            for (int j = 0; j <= n; j++) {
                f[i][j] = f[i-1][j];
                for (int k = 1; k * x <= j ; k++) {
                    if (f[i-1][j-k*x] != 0x3f3f3f3f) {
                        f[i][j] = Math.min(f[i][j], f[i-1][j -k*x] + k);
                    }
                }
            }
        }
        return f[m][m];
    }
}
