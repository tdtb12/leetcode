import java.util.*;


// https://leetcode.com/problems/sort-array-by-increasing-frequency/?envType=daily-question&envId=2024-07-23
public class FrequencySort {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(frequencySort(new int[]{-1,1,-6,4,5,-6,1,4,1})));
    }

    public static int[] frequencySort(int[] nums) {
        HashMap<Integer, Integer> frequency = new HashMap<>();
        for (int num : nums) {
            int numCount = frequency.getOrDefault(num, 0);
            frequency.put(num, numCount + 1);
        }
        System.out.println("frequency: " + frequency);

        int[] res = new int[nums.length];
        TreeMap<Integer, List<Integer>> treeMap = new TreeMap<>(Comparator.comparingInt(Integer::intValue));
        frequency.forEach((key, value) -> {
            List<Integer> keys = treeMap.getOrDefault(value,new ArrayList<Integer>());
            keys.add(key);
            treeMap.put(value, keys);
        });

        var ref = new Object() {
            int i = 0;
        };
        treeMap.forEach((freq, list)->{
            list.sort(Comparator.comparingInt(Integer::intValue).reversed());
            for (Integer key : list) {
                for (int j = 0; j < freq; j++) {
                    res[ref.i] = key;
                    ref.i++;
                }
            }
        });
        return res;
    }
}
