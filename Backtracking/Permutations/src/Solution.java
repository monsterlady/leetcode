import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        //前提条件
        if (nums.length == 0) {
            return null;
        }
        //初始化
        List<List<Integer>> list = new ArrayList<>();
        backtrack(list, new ArrayList<>(), nums, new boolean[nums.length]);
        return list;
    }

    private void backtrack(List<List<Integer>> list, List<Integer> temp, int[] nums, boolean[] isUsed) {
        //如果数列的长度与传入的数组一致则加入后return
        if (temp.size() == nums.length) {
            list.add(new ArrayList<>(temp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            //如果该数已被使用过则直接跳过此次循环
            if (isUsed[i]) {
                continue;
            }
            //加入临时数组
            temp.add(nums[i]);
            //标记为使用过
            isUsed[i] = true;
            //进入下一个回溯
            backtrack(list, temp, nums,isUsed);
            /*当最后一个backtrack返回return的时候,每一个栈开始运行后面的代码*/
            //标记为未使用
            isUsed[i] = false;
            //移除刚刚添加的元素
            temp.remove(temp.size() - 1);
        }
    }
}
