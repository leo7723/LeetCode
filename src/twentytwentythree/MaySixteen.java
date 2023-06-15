package twentytwentythree;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

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

    public int removeDuplicates(int[] nums) {
        if (nums.length <= 2) {
            return nums.length;
        }
        int i = 2,j = 2;
        while (j < nums.length) {
            if (nums[i-2] != nums[j]) {
                nums[i] = nums[j];
                ++i;
            }
            ++j;
        }
        return i;
    }

    public static void main(String[] args) {
        new MaySixteen().lengthOfLongestSubstring("bbbbbbbb");
    }
}
