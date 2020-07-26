import java.util.HashMap;
import java.util.Map;

/**
 * leetcode - https://leetcode.com/problems/two-sum
 */
public class TwoSumFinder {
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> countMap = new HashMap<>();
        Map<Integer, Integer> indexMap = new HashMap<>();
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            countMap.put(nums[i], countMap.getOrDefault(nums[i], 0) + 1);
            indexMap.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            if ((target - nums[i]) == nums[i]) {
                if (countMap.getOrDefault(target-nums[i], 0) > 1) {
                    result[0] = i;
                    result[1] = indexMap.get(target-nums[i]);
                    return result;
                }
            } else {
                if (countMap.getOrDefault(target-nums[i], 0) > 0) {
                    result[0] = i;
                    result[1] = indexMap.get(target-nums[i]);
                    return result;
                }
            }
        }
        throw new IllegalArgumentException("Sum not found");
    }

    public static void main(String[] args) {
        int[] indices = TwoSumFinder.twoSum(new int[] {2,7,11,15},9);
        System.out.println(indices[0] + "," + indices[1]);
    }
}
