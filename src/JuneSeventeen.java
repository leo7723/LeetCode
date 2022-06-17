import java.util.HashSet;

public class JuneSeventeen {
    public int lengthOfLongestSubstring(String s) {
        int i = 0 , result = 0;
        HashSet<Character> res = new HashSet<>();
        for (char ch : s.toCharArray()) {
            while (res.contains(ch)) {
                res.remove(s.charAt(i ++));
            }
            res.add(ch);
            result = Math.max(result, res.size());
        }
        return result;
    }
}
