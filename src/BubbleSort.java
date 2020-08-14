public class BubbleSort {

    public static void sort(int[] a) {
        int n = a.length;
        boolean flag = false;
        for (int j = 0; j < n-1; j++) {
            for (int i = 0; i < a.length - 1 -j; i++) {
                if (a[i] > a[i + 1]) {
                    int temp = a[i];
                    a[i] = a[i + 1];
                    a[i + 1] = temp;
                    flag = true;
                }
            }
            if (flag == false) break;
            flag = false;
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
