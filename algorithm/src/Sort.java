import org.junit.Test;

public class Sort {


    @Test
    public void sortTest(){
        int[] nums = {2,5,4,7,1,5};
        quickSort(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }
    public int[] maopaoSort(int[] nums){
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length-1-i; j++) {
                if (nums[j]>nums[j+1]){
                    swap(nums,j,j+1);
                }
            }
        }
        return nums;
    }

    /*******************************************************
     *快速排序 (比较排序类)
     *每次排序将待排记录分割两部分,一部分都比关键字小,一部分都比关键字大
     ********/
    public void quickSort(int[] L) {
        Qsort(L,0,L.length-1);
    }

    public void Qsort(int[] L,int low,int high) {
        int pivot;
        if(low<high) {
            //将L[low,high]一分为二,算出枢轴值pivot,该值得位置固定,不用再变化
            pivot=partition0(L,low,high);

            //对两边的数组分别排序
            Qsort(L,low,pivot-1);
            Qsort(L,pivot+1,high);
        }
    }

    //  选择一个枢轴值(关键字) 把它放到某个位置 使其左边的值都比它小 右边的值都比它大
    public int partition0(int[] L,int low,int high) {
        int pivotkey;
        pivotkey=L[low];
        //顺序很重要，要先从右边找
        while(low<high) {
            while(low<high && L[high]>=pivotkey) {  //从后往前找到比key小的放到前面去
                high--;
            }
            swap(L,high,low);
            while(low<high && L[low]<=pivotkey) {  //从前往后找到比key大的 放到后面去
                low++;
            }
            swap(L,high,low);
        } //遍历所有记录  low的位置即为 key所在位置, 且固定,不用再改变
        return low;
    }


    public void swap(int[] L,int i,int j) {
        int temp=L[i];
        L[i]=L[j];
        L[j]=temp;

    }
}
