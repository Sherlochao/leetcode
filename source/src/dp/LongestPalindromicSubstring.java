package dp;

/**
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * 示例 1：
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 * 输入: "cbbd"
 * 输出: "bb"
 */
public class LongestPalindromicSubstring {

    public static void main(String[] args) {
        System.out.println(new LongestPalindromicSubstring().longestPalindrome1("baabb"));
    }

    /**
     * dp
     */
    public String longestPalindrome1(String s) {
        if (s.isEmpty()) {
            return s;
        }
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        int left = 0, right = 0;
        for (int i = len - 2; i >= 0; i--) {
            dp[i][i] = true;
            for (int j = i + 1; j < len; j++) {
                // if charAt(i) == charAt(j)
                //     j - i == 0 回文 a
                //     j - i == 1 回文 aa
                //     j - i == 2 回文 aba
                dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i < 2 || dp[i + 1][j - 1]);
                if (dp[i][j] && right - left < j - i) {
                    left = i;
                    right = j;
                }
            }
        }
        return s.substring(left, right + 1);
    }

    /**
     * 暴力法 O(n * n * n)
     * leetcode会超时
     */
    public String longestPalindrome(String s) {
        int maxLength = 0;
        String maxString = "";
        for (int i = 0; i <= s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                if (isPalindrome(s.substring(i, j))) {
                    if (maxLength < j - i) {
                        maxLength = j - i;
                        maxString = s.substring(i, j);
                    }
                }
            }
        }
        return maxString;
    }

    private boolean isPalindrome(String s) {
        for (int i = 0, j = s.length() - 1; i <= j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }
}
