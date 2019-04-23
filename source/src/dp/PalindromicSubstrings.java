package dp;

/**
 * 给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。
 * 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被计为是不同的子串。
 *
 * 示例 1:
 * 输入: "abc"
 * 输出: 3
 * 解释: 三个回文子串: "a", "b", "c".
 *
 * 示例 2:
 * 输入: "aaa"
 * 输出: 6
 * 说明: 6个回文子串: "a", "a", "a", "aa", "aa", "aaa".
 *
 * 注意:
 * 输入的字符串长度不会超过1000。
 */
public class PalindromicSubstrings {

    public int countSubstrings(String s) {
        if (null == s || s.length() == 0) {
            return 0;
        }
        int len = s.length();
        // 单个字符一定是回文
        int result = len;
        boolean[][] dp = new boolean[len][len];
        for (int i = len - 2; i >= 0; i--) {
            dp[i][i] = true;
            for (int j = i + 1; j < len; j++) {
                // if charAt(i) == charAt(j)
                //     j - i == 0 回文 a
                //     j - i == 1 回文 aa
                //     j - i == 2 回文 aba
                dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i < 2 || dp[i + 1][j - 1]);
                if (dp[i][j]) {
                    result++;
                }
            }
        }
        return result;
    }
}
