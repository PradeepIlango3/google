package recursion;

public class StringReverse {

    public static void reverse(String s) {
        char[] charArray = s.toCharArray();
        printReverse(charArray, 0, charArray.length);
        System.out.println();
    }

    public static void reverse(char[] chars) {
        reverse(chars, 0 , chars.length-1);
    }

    private static void reverse(char[] chars, int s, int e) {
        if (s>=e) return;
        reverse(chars, s+1, e-1);
        char temp = chars[e];
        chars[e] = chars[s];
        chars[s] = temp;
    }

    private static void printReverse(char[] chars, int s, int len) {
        if (s == len) return;
        else {
            printReverse(chars, s+1, len);
            System.out.print(chars[s]);
        }
    }

    public static void main(String[] args) {
        StringReverse.reverse(new String("Taj Mahal"));
        char[] chars = {'T', 'a', 'j'};
        StringReverse.reverse(chars);
        System.out.println(chars);
    }
}
