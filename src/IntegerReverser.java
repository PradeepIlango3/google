/**
 * leetcode - https://leetcode.com/problems/reverse-integer/
 */
public class IntegerReverser {

    public static int reverse(int x) {
        long reverseX = 0;
        while (x != 0) {
            reverseX = (reverseX * 10) + (x % 10);
            x = x / 10;
        }
        if ((reverseX > Integer.MAX_VALUE) || (reverseX < Integer.MIN_VALUE)) {
            return 0;
        }
        return (int) reverseX;
    }

    public static void main(String[] args) {
        System.out.println(IntegerReverser.reverse(8758));
        System.out.println(IntegerReverser.reverse(-123));
    }

}
