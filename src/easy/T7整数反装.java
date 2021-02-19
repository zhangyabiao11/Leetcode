package easy;
//����һ�� 32 λ���з������� x ������ x ��ÿλ�ϵ����ַ�ת��Ľ����
//
// �����ת���������� 32 λ���з��������ķ�Χ [?231, 231 ? 1] ���ͷ��� 0��
//���軷��������洢 64 λ�������з��Ż��޷��ţ���
//
//
//
// ʾ�� 1��
//
//
//���룺x = 123
//�����321
//
//
// ʾ�� 2��
//
//
//���룺x = -123
//�����-321
//
//
// ʾ�� 3��
//
//
//���룺x = 120
//�����21
//
//
// ʾ�� 4��
//
//
//���룺x = 0
//�����0
//
//
//
//
// ��ʾ��
//
//
// -231 <= x <= 231 - 1
//
// Related Topics ��ѧ
// ? 2535 ? 0
public class T7������װ {
    public static void main(String[] args) {
        int x = -2063847412;
        System.out.println(reverse(x));
//        System.out.println(Integer.MIN_VALUE);
    }

    /**
     * �ٷ��ⷨ��
     *
     * �������������������� & ���ǰ���м��
     * ˼·
     *
     * ���ǿ���һ�ι�����ת������һλ���֡�����������ʱ�����ǿ���Ԥ�ȼ����ԭ����������һλ�����Ƿ�ᵼ�������
     *
     * �㷨
     *
     * ��ת�����ķ��������뷴ת�ַ���������ȡ�
     *
     * �������ظ��������� xx �����һλ���֣������������롱�� rev �ĺ��档���rev ���� x �෴��
     *
     * Ҫ��û�и�����ջ / ����İ����� �������� �� �����롱 ���֣����ǿ���ʹ����ѧ������
     *
     * //pop operation:
     * pop = x % 10;
     * x /= 10;
     *
     * //push operation:
     * temp = rev * 10 + pop;
     * rev = temp;
     * ���ǣ����ַ�����Σ�գ���Ϊ�� temp = rev * 10 + pop ʱ�ᵼ�������
     *���˵��ǣ����ȼ���������Ƿ�ᵼ����������ס�
     *
     * Ϊ�˱��ڽ��ͣ����Ǽ��� rev��������
     *
     * ��� temp = rev* 10 + pop �����������ôһ���� rev >= Integer.MAX_VALUE / 10
     * ��� rev > Integer.MAX_VALUE / 10 ����ô temp = rev * 10 + pop һ���������
     * ��� rev == Integer.MAX_VALUE / 10 ����ôֻҪ pop > 7��temp = rev * 10 + pop �ͻ������
     * �� rev Ϊ��ʱ����Ӧ�����Ƶ��߼���
     *
     * ���Ӷȷ���
     * ʱ�临�Ӷȣ�O(log(x))��x �д�Լ�� log_{10}(x) λ���֡�
     * �ռ临�Ӷȣ�O(1)��
     *
     * ���ߣ�LeetCode
     * ���ӣ�https://leetcode-cn.com/problems/reverse-integer/solution/zheng-shu-fan-zhuan-by-leetcode/
     * ��Դ�����ۣ�LeetCode��
     * ����Ȩ���������С���ҵת������ϵ���߻����Ȩ������ҵת����ע��������
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
     * ���нⷨ
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
