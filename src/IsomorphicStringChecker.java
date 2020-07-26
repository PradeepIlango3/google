import java.util.HashMap;
import java.util.Map;

/**
 * leet code problem : https://leetcode.com/problems/isomorphic-strings/
 */
public class IsomorphicStringChecker {

    public static void main(String[] args) {
        IsomorphicStringChecker isomorphicStringChecker = new IsomorphicStringChecker();
        System.out.println(isomorphicStringChecker.isIsomorphic("egg", "add"));
        System.out.println(isomorphicStringChecker.isIsomorphic("foo", "bar"));
        System.out.println(isomorphicStringChecker.isIsomorphic("paper", "title"));
    }

    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> replaceToMap = new HashMap<>();
        Map<Character, Character> replaceFromMap = new HashMap<>();
        char[] src = s.toCharArray();
        char[] dest = t.toCharArray();

        for (int i = 0; i < src.length; i++) {
            if (replaceToMap.get(src[i]) == null) {
                if (replaceFromMap.get(dest[i]) == null) {
                    replaceToMap.put(src[i], dest[i]);
                    replaceFromMap.put(dest[i], src[i]);
                } else if (replaceFromMap.get(dest[i]) != src[i]) {
                    return false;
                }
            } else if (replaceToMap.get(src[i]) != dest[i]) {
                return false;
            }
        }
        return true;
    }
}
