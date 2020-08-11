import java.util.*;

public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        //初始化数组
        List<List<Integer>> output_arry = new ArrayList<>();
        //从小到大进行排序
        Arrays.sort(nums);
        //遍历
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0) {
                //如果第一个数大于0，则不可能三数相加等于0
                break;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                //相同情况则跳过
                continue;
            }
            int target = -nums[i];
            int left = i + 1; //左指针
            int right = nums.length - 1;//右指针
            while (left < right) {
                if (nums[left] + nums[right] == target) {
                    output_arry.add(new ArrayList<>(Arrays.asList(nums[left], nums[i], nums[right])));
                    left++;
                    right--;
                    //情况为[-2,-2,-2,2,2]
                    while (left < right && nums[left] == nums[left - 1]) left++;
                    while (left < right && nums[right] == nums[right + 1]) right--;
                } else if (nums[left] + nums[right] < target) {
                    //情况为[-2,1,2,0]
                    left++;
                } else {
                    //情况为[-2,1,1,2]
                    right--;
                }
            }
        }
        return output_arry;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
    }
}