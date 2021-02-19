package easy;

import java.util.HashMap;
import java.util.Map;

//����һ���������� nums ��һ������Ŀ��ֵ target�������ڸ��������ҳ� ��ΪĿ��ֵ ���� ���� ���������������ǵ������±ꡣ
//
// ����Լ���ÿ������ֻ���Ӧһ���𰸡����ǣ�������ͬһ��Ԫ�ز���ʹ�����顣
//
// ����԰�����˳�򷵻ش𰸡�
//
//
//
// ʾ�� 1��
//
//
//���룺nums = [2,7,11,15], target = 9
//�����[0,1]
//���ͣ���Ϊ nums[0] + nums[1] == 9 ������ [0, 1] ��
//
//
// ʾ�� 2��
//
//
//���룺nums = [3,2,4], target = 6
//�����[1,2]
//
//
// ʾ�� 3��
//
//
//���룺nums = [3,3], target = 6
//�����[0,1]
//
//
//
//
// ��ʾ��
//
//
// 2 <= nums.length <= 103
// -109 <= nums[i] <= 109
// -109 <= target <= 109
// ֻ�����һ����Ч��
//
// Related Topics ���� ��ϣ��
// ? 10214 ? 0
public class T1����֮�� {

    public static void main(String[] args) {
        int[] nums ={12,7,11,-2,90,-90,0,80,-80};
        int[] twoSum = twoSum(nums, 0);
        System.out.println(twoSum[0]);
        System.out.println(twoSum[1]);
    }
    public static int[] test(int[] nums, int target) {

        for (int i = 0; i < nums.length; i++) {
            int a = target - nums[i];
            for (int j = i+1; j < nums.length; j++) {
                if (a==nums[j]){
                    return new int[]{i,j};
                }
            }
        }
        return null;
    }

    /**
     * ����֮�Ͳο���
     * @param nums ����
     * @param target Ŀ��ֵ
     * @return ��
     */
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])){
                return new int[]{i,map.get(nums[i])};
            }
            map.put(target-nums[i],i);
        }
        return null;
    }
}
