import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


// https://leetcode.com/problems/divide-a-string-into-groups-of-size-k/?envType=daily-question&envId=2025-06-22
public class DivideString {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(divideString("abcdefghi", 3, 'x')));
        System.out.println(Arrays.toString(divideString("abcdefghij", 3, 'x')));
    }

    public static String[] divideString(String s, int k, char fill) {
        List<String> ans = new ArrayList<>();
        while (!s.isEmpty()) {
            if (s.length() >= k) {
                ans.add(s.substring(0, k));
                s = s.substring(k);
            } else {
                ans.add(String.format("%-" + k + "s", s).replace(' ', fill));
                s = "";
            }
        }
        return ans.toArray(new String[0]);
    }
}
