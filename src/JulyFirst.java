import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class JulyFirst {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        part("(", 1, 0, n, result);
        return result;
    }

    private void part(String str, int l, int r, int n, List<String> result) {
        if (r > l || l > n || r > n) return;
        if (l == r && l == n) {
            result.add(str);
            return;
        }
        part(str + '(', l + 1, r, n, result);
        part(str + ')', l, r + 1, n, result);
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

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head = new ListNode();
        PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });

        for (ListNode  node: lists) {
            if (node != null) {
                queue.add(node);
            }
        }
        ListNode temp = head;
        while (!queue.isEmpty()) {
            temp.next = queue.poll();
            if (temp.next.next != null) {
                queue.add(temp.next.next);
            }
            temp = temp.next;
        }
        return head.next;
    }
}
