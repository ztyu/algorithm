import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BoyerMoore {


    /**
     * 多数投票算法
     */
    @Test
    public void boyerMooreTest() {
        List<Integer> res = majorityElement(new int[]{1, 13, 42, 5, 99, 7, 1, 1, 1, 8, 8, });
        res.forEach(System.out::println);
    }


    private List<Integer> majorityElement(int[] nums) {
        List<Integer> marjority = new ArrayList<>();
        int n = nums.length;
        int candidate1 = 0, candidate2 = 0, counter1 = 0, counter2 = 0;
        for (int i : nums) {
            if (candidate1 == i) {
                counter1++;
            } else if (candidate2 == i) {
                counter2++;
            } else if (counter1 == 0) {
                candidate1 = i;
                counter1 = 1;
            } else if (counter2 == 0) {
                candidate2 = i;
                counter2 = 1;
            } else {
                counter1--;
                counter2--;
            }
        }
        counter1 = 0;
        counter2 = 0;
        for (int i : nums) {
            if (i == candidate1) counter1++;
            else if (i == candidate2) counter2++;
        }
        if (counter1 > n / 3) marjority.add(candidate1);
        if (counter2 > n / 3) marjority.add(candidate2);
        return marjority;
    }


}
