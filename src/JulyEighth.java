import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JulyEighth {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates.length == 0) return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        Arrays.sort(candidates);
        part(candidates, target, res, path, 0);
        return res;
    }

    private void part(int[] candidates, int target, List<List<Integer>> res, List<Integer> path, int start) {

        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            if (target - candidates[i] < 0) {
                break;
            }
            path.add(candidates[i]);
            part(candidates, target - candidates[i], res, path, i);
            path.remove(path.size()-1);
        }
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode reverseList2(ListNode head) {
        ListNode dummy = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = dummy;
            dummy = head;
            head = next;
        }
        return dummy;
    }

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode newHead = reverseList(head);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}
