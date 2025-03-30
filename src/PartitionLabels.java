import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/partition-labels/solutions/?envType=daily-question&envId=2025-03-30
public class PartitionLabels {
    public static void main(String[] args) {
        System.out.println(partitionLabels("ababcbacadefegdehijhklij"));
        System.out.println(partitionLabels("eccbbbbdec"));
    }

    public static List<Integer> partitionLabels(String s) {
        List<Integer> ans = new ArrayList<>();

        int[] lastIdx = new int[26];
        for (int i = 0; i < s.toCharArray().length; i++) {
            lastIdx[s.charAt(i) - 'a'] = i;
        }

        int start = 0, end = 0;
        for (int i = 0; i < s.toCharArray().length; i++) {
            end = Math.max(end, lastIdx[s.charAt(i) - 'a']);
            if (i == end) {
                ans.add(i - start + 1);
                start = i + 1;
            }
        }
        return ans;
    }
}
