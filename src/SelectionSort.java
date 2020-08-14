public class SelectionSort {

    public static void sort(int[] a) {
        int n = a.length;
        int minIndex;
        for (int i = 0; i < n-1; i++) {
            minIndex = i;
            for (int j = i+1; j <n; j++) {
                if (a[j] < a[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = a[i];
            a[i] = a[minIndex];
            a[minIndex] = temp;
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
