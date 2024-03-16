//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class FourKeysKeyBoard {
    public static void main(String[] args) {
        System.out.println(solution(7));
        System.out.println(solution(11));
        System.out.println(solutionDp(7));
        System.out.println(solutionDp(11));
    }

    public static int solution(int n) {
        int result = n;

        for (int i = 1; i <= n - 3; i++) {
            result = Math.max(result, solution(i) * (n - 1 - i));
        }

        return result;
    }

    public static int solutionDp(int n) {
        int[] dp = new int[n+1];
        dp[0]=0;
        for (int i=1;i<=n;i++) {
            dp[i]= i;
            for (int j = 1; j < i-2; j++) {
                dp[i]=Math.max(dp[i],dp[j]*(i-j-1));
            }
        }

        return dp[n];
    }
}