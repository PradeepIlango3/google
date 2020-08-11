public class BinaryStringGenerator {

    public static void generate(int n) {
        StringBuilder result= new StringBuilder();
        for (int i = 0; i < n; i++) {
            result.append('0');
        }
        generateUtil(n, result);
    }

    public static void generateKary(int n, int k) {
        StringBuilder result= new StringBuilder();
        for (int i = 0; i < n; i++) {
            result.append('0');
        }
        generateKaryUtil(n, result, k);
    }

    public static void generateKaryUtil(int n, StringBuilder result, int k) {
        if (n == 0) {
            System.out.println(result);
            return;
        } else {
            for (int i = 0; i < k; i++) {
                result.replace(n-1, n, Character.toString((char)('0' + i)));
                generateKaryUtil(n-1, result, k);
            }
        }
    }

    public static void generateUtil(int n, StringBuilder result) {
        if (n == 0) {
            System.out.println(result);
            return;
        } else {
            result.replace(n-1, n, "0");
            generateUtil(n-1, result);
            result.replace(n-1, n, "1");
            generateUtil(n-1, result);
        }
    }

    public static void main(String[] args) {
        System.out.println("Binary");
        BinaryStringGenerator.generate(5);
        System.out.println("Kary");
        BinaryStringGenerator.generateKary(5, 3);
    }
}
