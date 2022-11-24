import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NovTwentyFive {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int [] inDegrees = new int[numCourses];
        List<List<Integer>> adjacency = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            adjacency.add(new ArrayList<>());
        }

        for (int[] pre : prerequisites) {
            inDegrees[pre[0]]++;
            adjacency.get(pre[1]).add(pre[0]);
        }

        for (int i = 0; i < numCourses; i++) {
            if (inDegrees[i] == 0) {
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            Integer pre = queue.poll();
            numCourses--;
            for (Integer cur : adjacency.get(pre)) {
                inDegrees[cur] --;
                if (inDegrees[cur] == 0) {
                    queue.add(cur);
                }
            }
        }
        return numCourses == 0;
    }
}
