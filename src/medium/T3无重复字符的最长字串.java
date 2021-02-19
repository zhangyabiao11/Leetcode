package medium;

import java.util.HashMap;
//����һ���ַ����������ҳ����в������ظ��ַ��� ��Ӵ� �ĳ��ȡ�
//
//
//
// ʾ�� 1:
//
//
//����: s = "abcabcbb"
//���: 3
//����: ��Ϊ���ظ��ַ�����Ӵ��� "abc"�������䳤��Ϊ 3��
//
//
// ʾ�� 2:
//
//
//����: s = "bbbbb"
//���: 1
//����: ��Ϊ���ظ��ַ�����Ӵ��� "b"�������䳤��Ϊ 1��
//
//
// ʾ�� 3:
//
//
//����: s = "pwwkew"
//���: 3
//����: ��Ϊ���ظ��ַ�����Ӵ���?"wke"�������䳤��Ϊ 3��
//?    ��ע�⣬��Ĵ𰸱����� �Ӵ� �ĳ��ȣ�"pwke"?��һ�������У������Ӵ���
//
//
// ʾ�� 4:
//
//
//����: s = ""
//���: 0
//
//
//
//
// ��ʾ��
//
//
// 0 <= s.length <= 5 * 104
// s ��Ӣ����ĸ�����֡����źͿո����
//
// Related Topics ��ϣ�� ˫ָ�� �ַ��� Sliding Window
// ? 4970 ? 0
public class T3���ظ��ַ�����ִ� {
    public static void main(String[] args) {
        String str = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(str));
    }

    /**
     * ��������
     * ˼·��
     * �������Ҫ�õ�˼·�ǣ���������
     *
     * ʲô�ǻ������ڣ�
     *
     * ��ʵ����һ������,���������е� abcabcbb������������У����ڣ�Ϊ abc ������ĿҪ�󣬵��ٽ��� a�����б���� abca����ʱ������Ҫ�����ԣ�����Ҫ�ƶ�������У�
     *
     * ����ƶ���
     *
     * ����ֻҪ�Ѷ��е���ߵ�Ԫ���Ƴ������ˣ�ֱ��������ĿҪ��
     *
     * һֱά�������Ķ��У��ҳ����г�����ĳ���ʱ������⣡
     *
     * ʱ�临�Ӷȣ�O(n)O(n)
     *
     * ���ߣ�powcai
     * ���ӣ�https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/solution/hua-dong-chuang-kou-by-powcai/
     * ��Դ�����ۣ�LeetCode��
     * ����Ȩ���������С���ҵת������ϵ���߻����Ȩ������ҵת����ע��������
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {
        if (s.length()==0) return 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max = 0;
        int left = 0;
        for(int i = 0; i < s.length(); i ++){
            if(map.containsKey(s.charAt(i))){
                left = Math.max(left,map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i),i);
            max = Math.max(max,i-left+1);
        }
        return max;

    }
}
