import java.util.*;

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
                part(result, phoneMap, digits, index + 1, combination);
                combination.deleteCharAt(index);
            }
        }
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {
        }
        ListNode(int val) {
            this.val = val;
        }
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        Queue<ListNode> queue = new LinkedList<>();
        ListNode temp = head;
        while (temp != null) {
            if (queue.size() == n+1) {
                queue.poll();
            }
            queue.add(temp);
            temp = temp.next;
        }
        if (queue.size() < n) {
            return head;
        }
        if (queue.size() == n) {
            return head.next;
        }
        temp = queue.poll();
        temp.next = temp.next.next;
        return head;
    }

    /**
     * 特殊场景 "]" "["
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        Stack<Character> characters = new Stack<>();
        char[] array = s.toCharArray();
        for (char ch : array) {
            if (ch == '(') {
                characters.push(')');
            } else if (ch == '[') {
                characters.push(']');
            } else if (ch == '{') {
                characters.push('}');
            } else {
                if (characters.empty()) return false;
                char temp = characters.pop();
                if (temp != ch) return false;
            }
        }
        return characters.empty();
    }
}
