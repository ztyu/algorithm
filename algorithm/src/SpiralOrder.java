
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;

import static java.lang.Math.max;

public class SpiralOrder {


    /**
     * 4k 矩形输出
     *
     * @param args
     */
    public static void main(String[] args) {
      /*  SpiralOrder spiralOrder=new SpiralOrder();
        int[][] matrix={{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16}};
        System.out.println(spiralOrder.spiralOrder(matrix));*/
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        char[] chars = str.toCharArray();
        int K = chars.length / 4;
        char[] spaces = new char[K - 1];
        for (int i = 0; i < K - 1; i++) {
            spaces[i] = ' ';
        }
        String spaceStr = new String(spaces);
        for (int i = 0; i < K + 1; i++) {//控制行数
            if (i == 0) {
                System.out.println(str.substring(0, K + 1));
            } else if (i < K) {
                System.out.println(chars[4 * K - i] + spaceStr + chars[K + i]);
            } else {
                System.out.println(new StringBuilder(str.substring(2 * K, 3 * K + 1)).reverse().toString());
            }
        }
    }

    @Test
    public void tee() {
        //准备好被查找的数组
        int[] arr = {2, 3, 5, 1, 6, 4, 9, 7, 8};
        //调用查找方法查找给定数组中5元素所在的索引值，并接收查找到的索引
        int index = getIndex(arr, 5);
        //输出索引
        System.out.println("index:" + index);
    }

    private static int getIndex(int[] arr, int num) {
        // 定义变量，表示查找数组范围的最左侧，先从0索引开始
        int left = 0;
        // 定义变量，表示查找数组范围的最右侧，先从最大索引开始
        int right = arr.length - 1;
        // 定义变量，表示查找范围的中间值
        int mid;
        while (left <= right) {
            // 中间索引 = (左侧  + 右侧) / 2
            // mid = (left + right) / 2;
            // 为了提高效率，我们可以用位运算代替除以运算
            mid = (left + right) >>> 2;
            if (arr[mid] > num) {
                //如果中间元素大于要查找元素，则在中间元素的左侧去找正确元素，最右侧变为mid - 1
                right = mid - 1;
            } else if (arr[mid] < num) {
                //如果中间元素小于要查找元素，则在中间元素的右侧去找正确元素，最左侧变为mid + 1
                left = mid + 1;
            } else {
                // 如果不大不小，那么就正好是找到了，返回找到的索引
                return mid;
            }
        }
        // 当查找范围的最左侧和最右侧重叠后还没有找到元素，则返回-1表示没有找到
        return -1;
    }

    private static AtomicBoolean atomicBoolean = new AtomicBoolean(true);

    @Test
    public void atomicBooleanTest() {
        System.out.println(atomicBoolean.toString());
    }


    /**
     * 任何数异或0值不变，任何数与自己异或值为0。
     * 此算法只是用存在一个不重复的数字
     */
    @Test
    public void findRepeatNum() {
        int[] arr = {3, 3, 2, 4, 2, 5, 5, 4, 9};
        //int res = Arrays.stream(arr).reduce(0, (a, b) -> a ^= b);
        int res = 0;
        for (int anArr : arr) {
            res ^= anArr;
        }
        System.out.println(res);
    }

    @Test
    public void dtest() {
        String x = "1,3,2";
        String y = "4,5,6,8,7,3,2";
        LCS_caculate(x, y);
    }


    private String LCS_caculate(String s1, String s2) {
        int size1 = s1.length();
        int size2 = s2.length();
        int chess[][] = new int[s1.length() + 1][s2.length() + 1];
        for (int i = 1; i <= size1; i++) {//根据上面提到的公式计算矩阵
            for (int j = 1; j <= size2; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    chess[i][j] = chess[i - 1][j - 1] + 1;
                } else {
                    chess[i][j] = max(chess[i][j - 1], chess[i - 1][j]);
                }
            }
        }
        int i = size1;
        int j = size2;
        StringBuffer sb = new StringBuffer();
        while ((i != 0) && (j != 0)) {//利用上面得到的矩阵计算子序列，从最右下角往左上走
            if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                sb.append(s1.charAt(i - 1));//相同时即为相同的子串
                i--;
                j--;
            } else {
                //i--与j--可调换位置
                if (chess[i][j - 1] > chess[i - 1][j]) {
                    i--;
                } else {
                    j--;
                }
            }
        }
        //System.out.println((double)sb.length()/s2.length()+","+(double)sb.length()/s1.length());
        System.out.println(sb.reverse().toString());
        return sb.reverse().toString();//记得反转
    }


    //------------^
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> m = new HashMap<>(nums.length);
        int[] res = new int[2];
        for (int i = 0; i < nums.length; ++i) {
            if (m.containsKey(target - nums[i])) {
                res[0] = i;
                res[1] = m.get(target - nums[i]);
                break;
            }
            m.put(nums[i], i);
        }
        return res;
    }


}
