import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class JanTwentyTwo {
    public int[] topKFrequent(int[] nums, int k) {
        if (k <= 0) {
            return new int[0];
        }

        HashMap<Integer, Integer> numMap = new HashMap<>();

        for (int i: nums) {
            if (numMap.containsKey(i)) {
                numMap.put(i, numMap.get(i) + 1);
            } else {
                numMap.put(i, 1);
            }
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return numMap.get(o1) - numMap.get(o2);
            }
        });

        for (int i: numMap.keySet()) {
            if (queue.size() < k) {
                queue.add(i);
            } else {
                if (numMap.get(queue.peek()) < numMap.get(i)) {
                    queue.poll();
                    queue.add(i);
                }
            }
        }

        int[] result = new int[k];
        for (int i = 0; !queue.isEmpty(); i++) {
            result[i] = queue.remove();
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new JanTwentyTwo().topKFrequent(new int[]{1,1,1,2,2,3}, 2));
    }
}
