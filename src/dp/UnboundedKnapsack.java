package dp;

public class UnboundedKnapsack {

    public static int maxRob(int val[], int wt[], int W) {
       int[] weights = new int[W+1];
       for (int i = 0; i <= W; i++) {
           for (int j = 0; j < wt.length; j++) {
               if (wt[j] <= i) {
                   int m = val[j] + weights[i - wt[j]];
                   if (m > weights[i]) {
                       weights[i] = m;
                   }
               }
           }
       }
       return weights[W];
    }

    public static void main(String[] args) {
        int[] val = {10, 40, 50, 70};
        int wt[]  = {1, 3, 4, 5};
        System.out.println(UnboundedKnapsack.maxRob(val,wt,8));
    }
}
