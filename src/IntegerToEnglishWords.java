// https://leetcode.com/problems/integer-to-english-words/description/?envType=daily-question&envId=2024-08-07
public class IntegerToEnglishWords {
    public static void main(String[] args) {
        System.out.println(numberToWords(1234567));
    }

    public static String numberToWords(int num) {
        if (num == 0) return "Zero";

        String res = numberStringDictionary(num % 1000);
        num = num / 1000;
        if (num > 0 && num % 1000 > 0) {
            res = numberStringDictionary(num % 1000) + "Thousand " + res;
        }
        num = num / 1000;
        if (num > 0 && num % 1000 > 0) {
            res = numberStringDictionary(num % 1000) + "Million " + res;
        }
        num = num / 1000;
        if (num > 0) {
            res = numberStringDictionary(num % 1000) + "Billion " + res;
        }
        return res.trim();
    }

    private static String numberStringDictionary(int num) {
        String res = "";
        String[] digitDictionary = new String[]{"Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
        String[] teenDictionary = new String[]{"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
        String[] tenthDictionary = new String[]{"", "", "Twenty", "Thirty", "Fourty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
        if (num / 100 > 0) {
            res += digitDictionary[num / 100] + " Hundred ";
            num = num % 100;
        }
        if (num < 20 && num > 9) {
            res += teenDictionary[num % 10] + " ";
        } else {
            if (num > 19) {
                res += tenthDictionary[num / 10] + " ";
            }
            num = num % 10;
            if (num > 0) {
                res += digitDictionary[num] + " ";
            }
        }
        return res;
    }


}
