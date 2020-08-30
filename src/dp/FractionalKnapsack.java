package dp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class FractionalKnapsack {

    static class Item {
        int val;
        int weight;
        Double ratio;
        public Item(int val, int weight) {
            this.val = val;
            this.weight = weight;
            ratio = (double) val/ (double) weight;
        }
    }

    public static double rob(int[] val, int[] wt, int W) {
        double value = 0;
        double rem = W;
        List<Item> items = new ArrayList<>();
        for (int i = 0; i < val.length; i++) {
            Item item = new Item(val[i], wt[i]);
            items.add(item);
        }
        Collections.sort(items, new Comparator<Item>() {
            @Override
            public int compare(Item o1, Item o2) {
                return o2.ratio.compareTo(o1.ratio);
            }
        });
        for (int i = 0; i < items.size(); i++) {
            if (rem == 0) return value;
            if (items.get(i).weight <= rem) {
                value+= items.get(i).val;
                rem = rem - items.get(i).weight;
            } else{
                value+= (rem/(double)items.get(i).weight) * items.get(i).val;
                rem = 0;
            }
        }
        return value;
    }

    public static void main(String[] args) {
        int[] wt = {10, 40, 20, 30};
        int[] val = {60, 40, 100, 120};
        int capacity = 50;
        System.out.println(FractionalKnapsack.rob(val, wt, capacity));
    }
}
