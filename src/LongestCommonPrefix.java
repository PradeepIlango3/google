/**
 * leetcode - https://leetcode.com/problems/longest-common-prefix
 */
public class LongestCommonPrefix {
    public static String longestCommonPrefix(String[] strs) {
        StringBuffer result = new StringBuffer();
        int j = 0;
        if (strs.length == 0) return "";
        if (strs.length == 1) return strs[0];
        while (true) {
            for (int i = 0 ; i < strs.length; i++) {
                if (j >= strs[i].length()) {
                    return result.toString();
                } else {
                    if (i > 0 && strs[i].charAt(j) != strs[i-1].charAt(j)) {
                        return result.toString();
                    }
                }
            }
            result.append(strs[0].charAt(j));
            j++;
        }
    }

    public static void main(String[] args) {
        System.out.println(LongestCommonPrefix.longestCommonPrefix
                (new String[] {"flower","flow","flight"}));
    }
}
