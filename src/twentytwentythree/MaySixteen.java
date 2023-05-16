package twentytwentythree;

import java.util.HashMap;
import java.util.HashSet;

public class MaySixteen {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        int q = 0, p = 0;
        char []  array = s.toCharArray();
        HashSet<Character> set = new HashSet<>();
        int result = 0;
        while (p < s.length()) {
            while (set.contains(array[p])) {
                set.remove(array[q]);
                q+=1;
            }
            set.add(array[p]);
            p+=1;
            result = Math.max(set.size(), result);
        }
        return result;
    }

    public static void main(String[] args) {
        new MaySixteen().lengthOfLongestSubstring("bbbbbbbb");
    }
}
