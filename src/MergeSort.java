public class MergeSort {

    private static void merge(int[] a, int[] l, int[] r) {
        int m = l.length;
        int n = r.length;
        int i = 0;
        int j = 0;
        int k = 0;
        while ((i < m) &&(j < n)) {
            if (l[i] <= r[j]) {
                a[k] = l[i];
                k++;
                i++;
            } else {
                a[k] = r[j];
                j++;
                k++;
            }
        }

        while (i < m) {
            a[k] = l[i];
            i++;
            k++;
        }

        while (j < n) {
            a[k] = r[j];
            j++;
            k++;
        }
    }

    public static void sort(int[] a) {
        int n = a.length;
        if (n > 1) {
            int mid = n/2;
            int[] l = new int[mid];
            int[] r = new int[n-mid];
            for (int i = 0; i <mid; i++) {
                l[i] = a[i];
            }
            for (int i = 0; i < (n-mid); i++) {
                r[i] = a[mid+i];
            }
            sort(l);
            sort(r);
            merge(a, l, r);
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
