import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JuneTwentySeven {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits.length() == 0) return result;
        Map<Character, String> phoneMap = new HashMap<>() {{
            put('2', "abc");
            put('2', "def");
            put('2', "ghi");
            put('2', "jkl");
            put('2', "abc");
            put('2', "mno");
            put('2', "pqrs");
            put('2', "tuv");
            put('2', "wxyz");
        }};
        part(result, phoneMap, digits, 0, new StringBuilder());
        return result;
    }

    public void part(List<String> result, Map<Character, String> phoneMap, String digits, int index, StringBuilder combination) {
        if (index == digits.length()) {
            result.add(combination.toString());
        } else {
            char digit = digits.charAt(index);
            String letters = phoneMap.get(digit);
            int lettersCount = letters.length();
            for (int i = 0; i < lettersCount; i++) {
                combination.append(letters.charAt(i));
                part(result, phoneMap, digits, index+1, combination);
                combination.deleteCharAt(index);
            }
        }
    }
}
