import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class t {

    @Test
    public void e(){
        System.out.println(lengthOfLongestSubstring2("ababdfabc"));
    }
    public int lengthOfLongestSubstring(String s) {
        int res = 0, left = 0, right = 0;
        HashSet<Character> t = new HashSet<Character>();
        while (right < s.length()) {
            if (!t.contains(s.charAt(right))) {
                t.add(s.charAt(right++));
                res = Math.max(res, t.size());
            } else {
                t.remove(s.charAt(left++));
            }
        }
        return res;
    }

    public int lengthOfLongestSubstring2(String s) {
        int[] m = new int[256];
        Arrays.fill(m, -1);
        int res = 0, left = -1;
        for (int i = 0; i < s.length(); ++i) {
            left = Math.max(left, m[s.charAt(i)]);
            m[s.charAt(i)] = i;
            res = Math.max(res, i - left);
        }
        return res;
    }

    public int[] twoSum(int[] nums,int tagert){
        HashMap<Integer,Integer> m = new HashMap<>();
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (m.containsKey(tagert-nums[i])){
                res[0] = nums[i];
                res[1] = tagert - nums[i];
                break;
            }
            m.put(nums[i],tagert-nums[i]);
        }
        return res;
    }

    @Test
    public void twoSumTest(){
        int[] nums = {2,5,7,9};
        int taget = 9;
        System.out.println(twoSum(nums,taget));
    }

    public int reverse(int t){
        /**
         * /结果等于得到的整数（商的整数）
         %取余（取模）有个规律就是：左边小于右边，结果为左边，左边大于右边，看余数
         */
        long res = 0;
        while (t != 0) {
            res = 10 * res + t % 10;
            t /= 10;
        }
        return (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) ? 0 : (int) res;
    }

    @Test
    public void reverseTest(){
       /* int t = 12324;
        System.out.println(reverse(t));*/
       long t = 4;
       System.out.println(t%10);
       System.out.println(t/10);
    }

    /**
     * 字符串获取int
     * @param str
     * @return
     */
    public int myAtoi(String str) {
        if (str.isEmpty()) return 0;
        int sign = 1, base = 0, i = 0, n = str.length();
        while (i < n && str.charAt(i) == ' ') ++i;
        if (i < n && (str.charAt(i) == '+' || str.charAt(i) == '-')) {
            sign = (str.charAt(i++) == '+') ? 1 : -1;
        }
        while (i < n && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
            if (base > Integer.MAX_VALUE / 10 || (base == Integer.MAX_VALUE / 10 && str.charAt(i) - '0' > 7)) {
                return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            base = 10 * base + (str.charAt(i++) - '0');
        }
        return base * sign;
    }
}
