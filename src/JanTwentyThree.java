import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class JanTwentyThree {

    /**
     * 由高到低排升高 第二项由低到高排
     * 排完按顺序查入
     * ArrayList 转换 int[] list.toArray(new int[list.size])
     * @param people
     * @return
     */
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] != o2[0]) {
                    return o2[0] - o1[0];
                } else {
                    return o1[1] - o2[1];
                }
            }
        });

        ArrayList<int[]> list = new ArrayList<>();
        for (int[] temp : people) {
                list.add(temp[1], temp);
        }
        return list.toArray(new int[list.size()][]); // ****
    }
}
