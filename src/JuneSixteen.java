import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class JuneSixteen {

    public static class ListNode {
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

    public static void main(String[] args) {
        ListNode listNode = new ListNode(3);
        ListNode listNode1 = new ListNode(7);
        listNode.next = listNode1;
        ListNode listNode2 = new ListNode(9);
        ListNode listNode3 = new ListNode(2);
        listNode2.next = listNode3;
        new JuneSixteen().addTwoNumbers(listNode, listNode2);
    }

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (v1, v2) -> v1[0] - v2[0]);
        int[][] res = new int[intervals.length][2];
        int idx = -1;
        for (int[] interval : intervals) {

            if (idx == -1 || interval[0] > res[idx][1]) {
                res[++idx] = interval;
            } else {
                // 反之说明重叠，则将当前区间合并至结果数组的最后区间
                res[idx][1] = Math.max(res[idx][1], interval[1]);
            }

        }
        return Arrays.copyOf(res, idx + 1);
    }

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (hashMap.containsKey(nums[i])) {
                return new int[]{hashMap.get(nums[i]), i};
            }
            hashMap.put(target - nums[i], i);
        }
        return new int[2];
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 != null) {
            return l2;
        }
        if (l1 != null && l2 == null) {
            return l1;
        }
        if (l1 == null && l2 == null) {
            return null;
        }
        ListNode head = new ListNode();
        ListNode temp = head;
        boolean extra = false;
        do {
            int i = (l1.val + l2.val  + (extra ? 1 : 0))%10;
            temp.next = new ListNode(i);
            extra = (l1.val + l2.val+ (extra ? 1 : 0))/10 == 1;
            temp = temp.next;
            l1 = l1.next;
            l2 = l2.next;
        } while (l1 != null && l2 != null);
        while (l1 != null) {
            if (extra) {
                int i = (l1.val +  1)%10;
                temp.next = new ListNode(i);
                extra = (l1.val +1)/10 == 1;
            } else {
                temp.next = l1;
                break;
            }
            temp = temp.next;
            l1 = l1.next;
        }
        while (l2 != null) {
            if (extra) {
                int i = (l2.val +  1)%10;
                temp.next = new ListNode(i);
                extra = (l2.val +1)/10 == 1;
            } else {
                temp.next = l2;
                break;
            }
            temp = temp.next;
            l2 = l2.next;
        }
        if (extra) {
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = new ListNode(1);
        }
        return head.next;
    }
}
