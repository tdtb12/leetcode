public class NumOfBeams {

    // https://leetcode.com/problems/number-of-laser-beams-in-a-bank/description/?envType=daily-question&envId=2025-10-27
    public static void main(String[] args) {
        System.out.println(numberOfBeams(new String[]{"011001","000000","010100","001000"}));
    }

    public static int numberOfBeams(String[] bank) {
        int lastRow = 0;
        int currentRow = 0;
        int ans = 0;
        for (String s : bank) {
            char[] chars = s.toCharArray();
            for (char c : chars) {
                currentRow += c - '0';
            }
            ans += lastRow * currentRow;
            lastRow = currentRow > 0 ? currentRow : lastRow;
            currentRow = 0;
        }
        return ans;
    }

}
