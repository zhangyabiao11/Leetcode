package easy;

import java.util.HashMap;
import java.util.Map;

//给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 的那 两个 整数，并返回它们的数组下标。
//
// 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
//
// 你可以按任意顺序返回答案。
//
//
//
// 示例 1：
//
//
//输入：nums = [2,7,11,15], target = 9
//输出：[0,1]
//解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
//
//
// 示例 2：
//
//
//输入：nums = [3,2,4], target = 6
//输出：[1,2]
//
//
// 示例 3：
//
//
//输入：nums = [3,3], target = 6
//输出：[0,1]
//
//
//
//
// 提示：
//
//
// 2 <= nums.length <= 103
// -109 <= nums[i] <= 109
// -109 <= target <= 109
// 只会存在一个有效答案
//
// Related Topics 数组 哈希表
// ? 10214 ? 0
public class T1两数之和 {

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
     * 两数之和参考答案
     * @param nums 数组
     * @param target 目标值
     * @return 答案
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
