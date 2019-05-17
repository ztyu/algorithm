import org.junit.Test;

import java.util.*;
import java.util.stream.IntStream;

public class t {

    @Test
    public void e() {
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

    public int[] twoSum(int[] nums, int tagert) {
        HashMap<Integer, Integer> m = new HashMap<>();
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (m.containsKey(tagert - nums[i])) {
                res[0] = nums[i];
                res[1] = tagert - nums[i];
                break;
            }
            m.put(nums[i], tagert - nums[i]);
        }
        return res;
    }

    @Test
    public void twoSumTest() {
        int[] nums = {2, 5, 7, 9};
        int taget = 9;
        System.out.println(twoSum(nums, taget));
    }

    public int reverse(int t) {
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
    public void reverseTest() {
       /* int t = 12324;
        System.out.println(reverse(t));*/
        long t = 4;
        System.out.println(t % 10);
        System.out.println(t / 10);
    }

    /**
     * 字符串获取int
     *
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

    @Test
    public void maxSubArray() {
        //最大子数组应为[4, -1, -2, 1, 5],其和为7。
        int[] nums = {2, -3, 4, -1, -2, 1, 5, -3};
        if (nums == null) System.out.println(Integer.MIN_VALUE);
        int sum = 0;
        int res = Integer.MIN_VALUE;
        for (int num : nums) {
            if (sum < 0) {
                sum = num;
            } else {
                sum += num;
            }
            res = Math.max(res, sum);
        }
        System.out.println(res);
    }

    @Test
    public void trimTest() {
        //zaijianjieke
    }

    @Test
    public void twoSum() {
        int[] nums = {2, 5, 6, 7, 8, 9};
        int taget = 9;
        HashSet<Integer> res = new HashSet<>();
        for (int num : nums) {
            if (res.contains(taget - num)) {
                System.out.println(num + "---" + (taget - num));
                res.remove(num);
            }
            res.add(num);
        }

    }

    @Test
    public void shootBall() {
        int[][] ball = {{10, 16}, {2, 8}, {1, 6}, {7, 12}};
        findMinArrowShots(ball);
    }

    private int findMinArrowShots(int[][] points) {
        if (points.length == 0) return 0;
        Arrays.sort(points, Comparator.comparingInt(a -> a[1]));
        int curPos = points[0][1];
        int ret = 1;
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] <= curPos) {
                continue;
            }
            curPos = points[i][1];
            System.out.println(curPos);
            ret++;
        }
        System.out.println(ret);
        return ret;
    }

    @Test
    public void streamTest() {
        IntStream.range(1, 10).map(x -> x + 1).filter(x -> x > 3).forEach(System.out::println);
    }

    public int search(int key, int[] array) {
        int l = 0, h = array.length - 1;
        while (l <= h) {
            int mid = l + (h - l) / 2;
            if (key == array[mid]) return mid;
            if (key < array[mid]) h = mid - 1;
            else l = mid + 1;
        }
        return -1;
    }

    public int binarySearchTest(int[] array, int key) {
        int l = 0, h = array.length - 1;
        while (l <= h) {
            int mid = l + (h - l) / 2;
            if (key == array[mid]) return mid;
            if (key <= array[mid]) h = mid - 1;
            else l = mid + 1;
        }
        return -1;
    }

    @Test
    public void coinTest() {
        System.out.println(arrangeCoins(8));
    }

    private int arrangeCoins(int n) {
        int l = 0, h = n;
        while (l <= h) {
            int m = l + (h - l) / 2;
            long x = m * (m + 1L) / 2;
            if (x == n) return m;
            else if (x < n) l = m + 1;
            else h = m - 1;
        }
        return h;
    }

    public int singleSearch(int[] array){
        return Arrays.stream(array).reduce(0, (a, b) -> a ^= b);
    }
    @Test
    public void test(){
        String s = "abc", t = "ahbgdc";
         System.out.println(isSubSequence(s,t));
    }
    private boolean isSubSequence(String s, String t) {
        for (int i = 0, pos = 0; i < s.length(); i++, pos++) {
            System.out.println(pos);
            pos = t.indexOf(s.charAt(i), pos);
            System.out.println(pos);
            if(pos == -1) return false;
        }
        return true;
    }

    @Test
    public void partitionLabelsTest(){
        String s = "ababcbacadefegdehijhklij";
        System.out.println(partitionLabels(s));
    }

    private List<Integer> partitionLabels(String S) {
        List<Integer> ret = new ArrayList<>();
        int[] lastIdxs = new int[26];
        for(int i = 0; i < S.length(); i++) {
            int sd = S.charAt(i) - 'a';
            //存储字符最后出现的位置
            lastIdxs[S.charAt(i) - 'a'] = i;
        }
        int startIdx = 0;
        while(startIdx < S.length()) {
            int endIdx = startIdx;
            for(int i = startIdx; i < S.length() && i <= endIdx; i++) {
                int lastIdx = lastIdxs[S.charAt(i) - 'a'];
                if(lastIdx == i) continue;
                if(lastIdx > endIdx) endIdx = lastIdx;
            }
            ret.add(endIdx - startIdx + 1);
            startIdx = endIdx + 1;
        }
        return ret;
    }

    /**
     *Input:
     * nums1 = [1,2,3,0,0,0], m = 3
     * nums2 = [2,5,6],       n = 3
     * Output: [1,2,2,3,5,6]
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1, j = n - 1; // 需要从尾开始遍历，否则在 nums1 上归并得到的值会覆盖还未进行归并比较的值
        int idx = m + n - 1;
        while(i >= 0 || j >= 0) {
            if (i < 0) nums1[idx] = nums2[j--];
            else if (j < 0) nums1[idx] = nums1[i--];
            else if (nums1[i] > nums2[j]) nums1[idx] = nums1[i--];
            else nums1[idx] = nums2[j--];
            idx--;
        }
    }


}
