import org.junit.Test;

import java.util.stream.IntStream;

public class Sort<pu> {


    @Test
    public void sortTest() {
        int[] nums = {2, 5, 4, 7, 1, 5};
        quickSort(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }

    public int[] maopaoSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length - 1 - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    swap(nums, j, j + 1);
                }
            }
        }
        return nums;
    }

    /*******************************************************
     *快速排序 (比较排序类)
     *每次排序将待排记录分割两部分,一部分都比关键字小,一部分都比关键字大
     ********/
    private void quickSort(int[] L) {
        Qsort(L, 0, L.length - 1);
    }

    private void Qsort(int[] L, int low, int high) {
        int pivot;
        if (low < high) {
            //将L[low,high]一分为二,算出枢轴值pivot,该值得位置固定,不用再变化
            pivot = partition0(L, low, high);

            //对两边的数组分别排序
            Qsort(L, low, pivot - 1);
            Qsort(L, pivot + 1, high);
        }
    }

    //  选择一个枢轴值(关键字) 把它放到某个位置 使其左边的值都比它小 右边的值都比它大
    private int partition0(int[] L, int low, int high) {
        int pivotkey;
        pivotkey = L[low];
        //顺序很重要，要先从右边找
        while (low < high) {
            while (low < high && L[high] >= pivotkey) {  //从后往前找到比key小的放到前面去
                high--;
            }
            swap(L, high, low);
            while (low < high && L[low] <= pivotkey) {  //从前往后找到比key大的 放到后面去
                low++;
            }
            swap(L, high, low);
        } //遍历所有记录  low的位置即为 key所在位置, 且固定,不用再改变
        return low;
    }



    private void swap(int[] L, int i, int j) {
        int temp = L[i];
        L[i] = L[j];
        L[j] = temp;
//        i = i ^ j;
//        j = i ^ j;
//        i = i ^ j;
    }

    @Test
    public void tt(){
        int i = 2;
        int j = 3;
        i = i ^ j;
        j = i ^ j;
        i = i ^ j;
        System.out.println(i);
        System.out.println(j);
    }

    //两路归并算法，两个排好序的子序列合并为一个子序列
    private void merge(int[] a, int left, int mid, int right) {
        int[] tmp = new int[a.length];//辅助数组
        int p1 = left, p2 = mid + 1, k = left;//p1、p2是检测指针，k是存放指针

        while (p1 <= mid && p2 <= right) {
            if (a[p1] <= a[p2])
                tmp[k++] = a[p1++];
            else
                tmp[k++] = a[p2++];
        }

        while (p1 <= mid) tmp[k++] = a[p1++];//如果第一个序列未检测完，直接将后面所有元素加到合并的序列中
        while (p2 <= right) tmp[k++] = a[p2++];//同上

        //复制回原素组
        /*for (int i = left; i <= right; i++)
            a[i] = tmp[i];*/
        IntStream.rangeClosed(left, right).forEach(i -> a[i] = tmp[i]);
    }

    private void mergeSort(int[] a, int start, int end) {
        if (start < end) {//当子序列中只有一个元素时结束递归
            int mid = (start + end) / 2;//划分子序列
            mergeSort(a, start, mid);//对左侧子序列进行递归排序
            mergeSort(a, mid + 1, end);//对右侧子序列进行递归排序
            merge(a, start, mid, end);//合并
        }
    }

    @Test
    public void test() {
        int[] a = {49, 38, 65, 97, 76, 13, 27, 50};
        mergeSort(a, 0, a.length - 1);
        System.out.println("排好序的数组：");
        for (int e : a)
            System.out.print(e + "");
    }

    @Test
    public void binarySerachTest(){
        int[] array = {1,5,6,8,9,18};
    }





}
