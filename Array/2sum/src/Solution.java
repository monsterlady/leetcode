import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        //初始化map
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = target - nums[i];
            //如果map中的key包含了想要的数字,则可获取其下角标
            if(map.containsKey(num)){
                return new int[]{
                        i,map.get(num)
                };
            }
            //如果没有的话,就将其下角标做值,数字作为key放进Map中
            //因为Map的特性是如果是一样的key,则只更新其对应的value
            //这样的话可以避免重复
            map.put(nums[i],i);
        }
        throw new IllegalArgumentException("No solution!");
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().twoSum(new int[]{3,7,2,4}, 9)));
    }
}