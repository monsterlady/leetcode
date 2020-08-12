public class Solution {
    public int trap(int[] height) {
        if(height.length <= 1){
            return 0;
        }
        int answer = 0;
        int left =0,right = height.length - 1;
        int leftHighest = height[left],rightHighest = height[right];
        while (left < right){
            if( leftHighest < rightHighest){
                answer += leftHighest - height[left];
                left++;
                leftHighest = Math.max(leftHighest,height[left]);
            } else {
                answer += rightHighest - height[right];
                right--;
                rightHighest = Math.max(rightHighest,height[right]);
            }
        }
        return  answer;
    }
}
