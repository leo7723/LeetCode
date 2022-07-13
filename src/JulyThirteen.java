import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class JulyThirteen {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> hashMap = new HashMap<>();
        for (String s : strs) {
            char[] temp = s.toCharArray();
            Arrays.sort(temp);
            String tempS = new String(temp);
            if (hashMap.containsKey(tempS)) {
                hashMap.get(tempS).add(s);
            } else {
                List<String> list =  new ArrayList<>();
                list.add(s);
                hashMap.put(tempS, list);
            }
        }

        return new ArrayList<>(hashMap.values());
    }
}
