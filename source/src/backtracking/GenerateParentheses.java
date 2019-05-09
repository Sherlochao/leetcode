package backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 *
 * 例如，给出 n = 3，生成结果为：
 *  [
 *      "((()))",
 *      "(()())",
 *      "(())()",
 *      "()(())",
 *      "()()()"
 *  ]
 */
public class GenerateParentheses {

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtracking(result, "", 0, 0, n);
        return result;
    }

    private void backtracking(List<String> result, String cur, int left, int right, int max) {
        if (cur.length() == max * 2) {
            result.add(cur);
            return;
        }
        // 还可增加左括号
        if (left < max) {
            backtracking(result, cur + "(", left + 1, right, max);
        }
        // 还可增加右括号
        if (right < left) {
            backtracking(result, cur + ")", left, right + 1, max);
        }
    }

    public static void main(String[] args) {
        System.out.println(new GenerateParentheses().generateParenthesis(3));
    }
}
