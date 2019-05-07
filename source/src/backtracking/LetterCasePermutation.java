package backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个字符串S，通过将字符串S中的每个字母转变大小写，我们可以获得一个新的字符串。返回所有可能得到的字符串集合。
 *
 * 示例:
 * 输入: S = "a1b2"
 * 输出: ["a1b2", "a1B2", "A1b2", "A1B2"]
 *
 * 输入: S = "3z4"
 * 输出: ["3z4", "3Z4"]
 *
 * 输入: S = "12345"
 * 输出: ["12345"]
 *
 * 注意：
 *      S 的长度不超过12。
 *      S 仅由数字和字母组成。
 */
public class LetterCasePermutation {

    /**
     * 回溯
     */
    public List<String> letterCasePermutation(String S) {
        List<String> result = new ArrayList<>();
        backtracking(result, S, new StringBuilder(), 0);
        return result;
    }

    private void backtracking(List<String> result, String s, StringBuilder newStr, int start) {
        if (start == s.length()) {
            result.add(newStr.toString());
            return;
        }
        char curChar = s.charAt(start);
        if (Character.isDigit(curChar)) {
            newStr.append(curChar);
            backtracking(result, s, newStr, start + 1);
            // 回退
            newStr.deleteCharAt(newStr.length() - 1);
        } else {
            newStr.append(Character.toLowerCase(curChar));
            backtracking(result, s, newStr, start + 1);
            // 回退
            newStr.deleteCharAt(newStr.length() - 1);
            newStr.append(Character.toUpperCase(curChar));
            backtracking(result, s, newStr, start + 1);
            // 回退
            newStr.deleteCharAt(newStr.length() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new LetterCasePermutation().letterCasePermutation("a1b2"));
    }
}
