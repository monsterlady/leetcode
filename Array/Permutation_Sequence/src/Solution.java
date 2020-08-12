import java.util.ArrayList;
import java.util.List;

public class Solution {
    private static int[] factor = new int[10];

    static {
        factor[0] = 1;
        factor[1] = 1;
        for (int i = 2; i < 10; i++) {
            factor[i] = factor[i -1] * i;
        }
    }

    public String getPermutation(int n, int k) {
        if(k < 0 || k > factor[n]){
            return null;
        }
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            numbers.add(i);
        }
        StringBuffer sb = new StringBuffer();
        while (numbers.size() > 0) {
            //获取数组的index
            int i = (k-1) / factor[--n];
            //更新K,因为刚刚减去了i个(从1到i)的(n - 1)!
            k -= i * factor[n];
            sb.append(numbers.remove(i));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().getPermutation(4,9));
    }
}