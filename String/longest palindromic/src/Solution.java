public class Solution {
    public String longestPalindrome(String s) {
        //前提条件
        if (s.length() < 2) {
            return s;
        }
        //初始化
        int length = s.length();
        String result = null;
        //区间
        boolean[][] pd = new boolean[length][length];
        //主体
        for (int i = 0; i < length; i++) {
            for (int k = i; k >= 0; k--) {
                //如果第一个和最后一个字符相等, 且词语的长度小于2且包含区间也为回文
                if (s.charAt(k) == s.charAt(i) && (i - k < 2 || pd[k + 1][i - 1])) {
                    //设为真区间
                    pd[k][i] = true;
                    //如果结果还没赋值或者目前的回文的长度大于之前的回文
                    if (result == null || i - k + 1 > result.length()) {
                        //给结果重新赋值
                        result = s.substring(k, i + 1);
                    }
                }
            }
        }
        return result;
    }
}
