import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class JulyTwenty {
    public void sortColors(int[] nums) {
        int i = 0, j = 0, k = nums.length - 1;
        int temp = 0;
        while (j <= k) {
            if (nums[j] == 0) {
                temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
                j++;
            } else if (nums[j] == 2) {
                temp = nums[k];
                nums[k] = nums[j];
                nums[j] = temp;
                k--;
            } else {
                j++;
            }

        }
    }

    HashMap<Character, Integer> aim = new HashMap<>();
    HashMap<Character, Integer> cnt = new HashMap<>();
    public String minWindow(String s, String t) {
        for (int i = 0; i < t.length(); i++) {
            aim.put(t.charAt(i), aim.getOrDefault(t.charAt(i), 0) + 1);
        }
        int ansL = 0, ansR = 0, len = Integer.MAX_VALUE;
        for (int left = 0, right = 0; right < s.length(); right++) {
            if (aim.containsKey(s.charAt(right))) {
                cnt.put(s.charAt(right), cnt.getOrDefault(s.charAt(right), 0) + 1);
            }

            while (check() && left <= right) {
                if (right-left+1 < len) {
                    len = right-left+1;
                    ansL = left;
                    ansR = left+len;
                }
                if (aim.containsKey(s.charAt(left))) {
                    cnt.put(s.charAt(left), cnt.getOrDefault(s.charAt(left), 0) -1);
                }
                left++;
            }
        }

        return len == Integer.MAX_VALUE ? "" : s.substring(ansL, ansR);
    }

    public boolean check() {
        for (Map.Entry<Character, Integer> characterIntegerEntry : aim.entrySet()) {
            Map.Entry entry = (Map.Entry) characterIntegerEntry;
            Character key = (Character) entry.getKey();
            Integer val = (Integer) entry.getValue();
            if (cnt.getOrDefault(key, 0) < val) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        new JulyTwenty().minWindow("ADOBECODEBANC","ABC");
    }
}
