import java.util.HashSet;

public class CountConsistentStrings {
    public int countConsistentStrings(String allowed, String[] words) {
        HashSet<Character> set = new HashSet<>();
        for (char allow : allowed.toCharArray()) {
            set.add(allow);
        }

        int ans = 0;
        for (String word : words) {
            boolean isConsistent = false;
            for (char c : word.toCharArray()) {
                if (!set.contains(c)) {
                    isConsistent = false;
                    break;
                }
                isConsistent = true;
            }
            if (isConsistent) {
                ans++;
            }
        }

        return ans;
    }
}
