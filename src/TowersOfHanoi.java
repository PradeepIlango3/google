public class TowersOfHanoi {

    public static void move(int n) {
        move(n, 'A', 'C', 'B');
    }

    private static void move(int n, char src, char des, char aux) {
        if (n == 1) {
            System.out.println(String.format("Move disk 1 from %c to %c", src, des));
            return;
        } else {
            move(n-1, src, aux, des);
            System.out.println(String.format("Move disk %d from %c to %c", n, src, des));
            move(n-1, aux, des, src);
        }
    }

    public static void main(String[] args) {
        TowersOfHanoi.move(4);
    }
}
