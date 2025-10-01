// https://leetcode.com/problems/water-bottles/submissions/1788273499/?envType=daily-question&envId=2025-10-01
public class NumWaterBottles {

    public static void main(String[] args) {
        System.out.println(numWaterBottles(9, 3));
        System.out.println(numWaterBottles(15, 4));
    }

    public static int numWaterBottles(int numBottles, int numExchange) {
        int drank = 0;

        while (numBottles >= numExchange) {
            drank += (numBottles / numExchange)*numExchange;
            numBottles = numBottles / numExchange + numBottles % numExchange;
        }
        return drank + numBottles;
    }
}
