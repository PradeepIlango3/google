public class InsertionSort {

    public static void sort(int[] a) {
        int n = a.length;
        for (int i = 1; i < n; i++) {
            int value = a[i];
            int hole = i;
            while ((hole > 0) && (a[hole-1] > value)) {
                a[hole] = a[hole-1];
                hole = hole -1;
            }
            a[hole] = value;
        }
    }

    public static void main(String[] args) {
        int[] a = new int[] {8, 10, 3, 100, 1, 909, 10000, 23, 125};
        sort(a);
        for (int i: a) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

}
