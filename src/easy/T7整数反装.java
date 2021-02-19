package easy;
//给你一个 32 位的有符号整数 x ，返回 x 中每位上的数字反转后的结果。
//
// 如果反转后整数超过 32 位的有符号整数的范围 [?231, 231 ? 1] ，就返回 0。
//假设环境不允许存储 64 位整数（有符号或无符号）。
//
//
//
// 示例 1：
//
//
//输入：x = 123
//输出：321
//
//
// 示例 2：
//
//
//输入：x = -123
//输出：-321
//
//
// 示例 3：
//
//
//输入：x = 120
//输出：21
//
//
// 示例 4：
//
//
//输入：x = 0
//输出：0
//
//
//
//
// 提示：
//
//
// -231 <= x <= 231 - 1
//
// Related Topics 数学
// ? 2535 ? 0
public class T7整数反装 {
    public static void main(String[] args) {
        int x = -2063847412;
        System.out.println(reverse(x));
//        System.out.println(Integer.MIN_VALUE);
    }

    /**
     * 官方解法：
     *
     * 方法：弹出和推入数字 & 溢出前进行检查
     * 思路
     *
     * 我们可以一次构建反转整数的一位数字。在这样做的时候，我们可以预先检查向原整数附加另一位数字是否会导致溢出。
     *
     * 算法
     *
     * 反转整数的方法可以与反转字符串进行类比。
     *
     * 我们想重复“弹出” xx 的最后一位数字，并将它“推入”到 rev 的后面。最后，rev 将与 x 相反。
     *
     * 要在没有辅助堆栈 / 数组的帮助下 “弹出” 和 “推入” 数字，我们可以使用数学方法。
     *
     * //pop operation:
     * pop = x % 10;
     * x /= 10;
     *
     * //push operation:
     * temp = rev * 10 + pop;
     * rev = temp;
     * 但是，这种方法很危险，因为当 temp = rev * 10 + pop 时会导致溢出。
     *幸运的是，事先检查这个语句是否会导致溢出很容易。
     *
     * 为了便于解释，我们假设 rev是正数。
     *
     * 如果 temp = rev* 10 + pop 导致溢出，那么一定有 rev >= Integer.MAX_VALUE / 10
     * 如果 rev > Integer.MAX_VALUE / 10 ，那么 temp = rev * 10 + pop 一定会溢出。
     * 如果 rev == Integer.MAX_VALUE / 10 ，那么只要 pop > 7，temp = rev * 10 + pop 就会溢出。
     * 当 rev 为负时可以应用类似的逻辑。
     *
     * 复杂度分析
     * 时间复杂度：O(log(x))，x 中大约有 log_{10}(x) 位数字。
     * 空间复杂度：O(1)。
     *
     * 作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/reverse-integer/solution/zheng-shu-fan-zhuan-by-leetcode/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param x
     * @return
     */
    public static int reverse(int x) {
        int result = 0;
        while (x != 0){
            int pop = x % 10;
            x /= 10;
            if (result > Integer.MAX_VALUE/10 || (result == Integer.MAX_VALUE/10 && pop > 7) ) return 0;
            if (result < Integer.MIN_VALUE/10 || (result == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            result = result * 10 + pop;
        }
        return result;
    }

    /**
     * 大佬解法
     * @param x
     * @return
     */
    public int reverse2(int x) {
        int ans = 0;
        while (x != 0) {
            if ((ans * 10) / 10 != ans) {
                ans = 0;
                break;
            }
            ans = ans * 10 + x % 10;
            x = x / 10;
        }
        return ans;
    }
}
