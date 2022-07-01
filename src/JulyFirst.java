import java.util.ArrayList;
import java.util.List;

public class JulyFirst {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        part("(", 1, 0, n , result);
        return result;
    }

    private void part(String str, int l, int r, int n, List<String> result) {
        if (r > l || l > n || r > n) return;
        if (l == r && l == n) {
            result.add(str);
            return;
        }
        part(str+'(', l+1, r, n, result);
        part(str+')', l, r+1, n, result);
    }
}
