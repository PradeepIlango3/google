/**
 * leetcode - https://leetcode.com/problems/remove-duplicates-from-sorted-array/
 */
public class SortedArrayDupicatesRemover {
    public static int removeDuplicates(int[] nums) {
        int start = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[start] != nums[i]) {
                start++;
                nums[start] = nums[i];
            }
        }
        return start + 1;
    }

    public static void main(String[] args) {
        System.out.println(SortedArrayDupicatesRemover
                .removeDuplicates(new int[] {0,0,1,1,1,2,2,3,3,4}));
    }
}
