package hash;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定字符串J 代表石头中宝石的类型，和字符串 S代表你拥有的石头。 S 中每个字符代表了一种你拥有的石头的类型，你想知道你拥有的石头中有多少是宝石。
 * J 中的字母不重复，J 和 S中的所有字符都是字母。字母区分大小写，因此"a"和"A"是不同类型的石头。
 *
 * 示例 1:
 * 输入: J = "aA", S = "aAAbbbb"
 * 输出: 3
 *
 * 示例 2:
 * 输入: J = "z", S = "ZZ"
 * 输出: 0
 *
 * 注意:
 * S 和 J 最多含有50个字母
 * J 中的字符不重复。
 */
public class JewelsAndStones {

    public int numJewelsInStones(String J, String S) {
        Set<Character> set = new HashSet<>(J.length());
        for (int i = 0; i < J.length(); i++) {
            if (!set.contains(J.charAt(i))) {
                set.add(J.charAt(i));
            }
        }
        int result = 0;
        for (int i = 0; i < S.length(); i++) {
            if (set.contains(S.charAt(i))) {
                result++;
            }
        }
        return result;
    }

    public int numJewelsInStones1(String J, String S) {
        int num = 0;
        for (int i = 0; i < S.length(); i++) {
            // indexOf 返回指定字符在字符串中第一次出现处的索引，如果此字符串中没有这样的字符，则返回 -1
            if (J.indexOf(S.charAt(i)) >= 0) {
                num++;
            }
        }
        return num;
    }

    public static void main(String[] args) {
        String J = "aA", S = "aAAbbbb";
        System.out.println(new JewelsAndStones().numJewelsInStones1(J, S));
    }
}
