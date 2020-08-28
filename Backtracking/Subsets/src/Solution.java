import java.util.*;

public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        //precondition
        if(nums.length == 0){
            return null;
        }
        //main
        List<List<Integer>> lists = new ArrayList<>();
        backtrack(lists,new ArrayList<>(),nums,0);
        return lists;
    }

    private void backtrack(List<List<Integer>> lists,List<Integer> temp, int[] nums, int start){
        lists.add(new ArrayList<>(temp));
        for (int i = start; i < nums.length; i++) {
            temp.add(nums[i]);
            backtrack(lists, temp, nums, i + 1);
            temp.remove(temp.size() - 1);
        }
    }
}
