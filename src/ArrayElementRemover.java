/**
 * leetcode - https://leetcode.com/problems/remove-element/
 */
public class ArrayElementRemover {

    public static int removeElement(int[] nums, int val) {
        int start = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                start++;
                nums[start] = nums[i];
            }
        }
        return start + 1;
    }

    public static void main(String[] args) {
        System.out.println(ArrayElementRemover.
                removeElement(new int[] {0,1,2,2,3,0,4,2}, 2));
    }
}
