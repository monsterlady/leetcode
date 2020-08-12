import java.util.Arrays;

public class Solution {
    public int threeSumClosest(int[] num, int target) {
        //如果没有元素或者元素少于3个的话,直接return null
        if (num == null || num.length < 3)
            return 0;
        int min = Integer.MAX_VALUE;
        int val = 0;
        Arrays.sort(num);
        for (int i = 0; i < num.length - 2; i++) {
            int low = i + 1;
            int high = num.length - 1;
            while (low < high) {
                int sum = num[i] + num[low] + num[high];
                //缩小区间才能赋值
                if (Math.abs(target - sum) < min) {
                    min = Math.abs(target - sum);
                    val = sum;
                }
                //移动左右指针
                if (target == sum) {
                    return val;
                } else if (target > sum) {
                    low++;
                } else {
                    high--;
                }
            }
        }
        return val;
    }
}