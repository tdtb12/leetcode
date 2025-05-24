package array;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/find-words-containing-character/description/?envType=daily-question&envId=2025-05-24
public class FindWordsContaining {
    public List<Integer> findWordsContaining(String[] words, char x) {
        List<Integer> ans = new ArrayList();

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            char[] chars = word.toCharArray();
            // use indexOf() is faster
            for (int j = 0; j < chars.length; j++) {
                if (chars[j]==x) {
                    ans.add(i);
                    break;
                }
            }
        }
        return ans;
    }
}
