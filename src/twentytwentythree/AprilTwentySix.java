package twentytwentythree;

import java.util.*;

public class AprilTwentySix {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (hashMap.containsKey(nums[i])) {
                return new int[]{hashMap.get(nums[i]), i};
            } else {
                hashMap.put(target - nums[i], i);
            }
        }
        return new int[2];
    }


    /**
     * 不能直接相加作为key 不一样的字母加起来也可能一样
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> hashMap = new HashMap<>();

        for (String str : strs) {
            int i = 0;
            char[] chars =  str.toCharArray();
            Arrays.sort(chars);
            if (hashMap.containsKey(new String(chars))) {
                List<String> list = hashMap.get(new String(chars));
                list.add(str);
            } else {
                List<String> list = new ArrayList<>();
                list.add(str);
                hashMap.put(new String(chars), list);
            }
        }
        List<List<String>> result = new ArrayList<>();
        hashMap.forEach((key,item)-> {
            result.add(item);
        });
        return result;
    }

    public int longestConsecutive(int[] nums) {
        Set<Integer> numsSet = new HashSet<>();
        for (int num : nums) {
            numsSet.add(num);
        }
        int longestLength = 0;
        for (int num : numsSet) {
            if (numsSet.contains(num-1)) {
                continue;
            }
            int length = 1;
            while (numsSet.contains(num+1)) {
                num += 1;
                length += 1;
            }
            longestLength = Math.max(length, longestLength);
        }
        return longestLength;
    }

    public static void main(String[] args) {
        new AprilTwentySix().twoSum(new int[]{2,7,11,15}, 9);
    }
}
