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
        System.out.println(new LongestPalindromicSubstring().longestPalindrome("a"));
    }

    /**
     * dp
     */
    public String longestPalindrome1(String s) {

        return null;
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
