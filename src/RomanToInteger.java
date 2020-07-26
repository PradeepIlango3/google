/**
 * leetcode - https://leetcode.com/problems/roman-to-integer/
 */
public class RomanToInteger {
    public static int romanToInt(String s) {
        int value = 0;
        int x;
        int y;
        for (int i = 0; i < s.length(); i++) {
            x = getRank(s.charAt(i));
            if (i + 1 < s.length() && (x <
                    getRank(s.charAt(i+1)))) {
                value = value -x + getRank(s.charAt(i+1));
                i++;
            } else {
                value = value + x;
            }
        }
        return value;
    }

    private static int getRank(char c) {
        switch(c) {
            case 'I' : return 1;
            case 'V' : return 5;
            case 'X' : return 10;
            case 'L' : return 50;
            case 'C' : return 100;
            case 'D' : return 500;
            case 'M' : return 1000;
            default: return 1;
        }
    }

    public static void main(String[] args) {
        System.out.println(RomanToInteger.romanToInt("MCMXCIV"));
    }
}
