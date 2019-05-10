
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SpiralOrder {


    /**
     * 4k 矩形输出
     * @param args
     */
    public static void main(String[] args) {
      /*  SpiralOrder spiralOrder=new SpiralOrder();
        int[][] matrix={{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16}};
        System.out.println(spiralOrder.spiralOrder(matrix));*/
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        char[] chars = str.toCharArray();
        int K = chars.length/4;
        char[] spaces = new char[K-1];
        for(int i = 0;i<K-1;i++){
            spaces[i] = ' ';
        }
        String spaceStr = new String(spaces);
        for(int i = 0;i < K+1;i++){//控制行数
            if(i == 0){
                System.out.println(str.substring(0,K+1));
            }else if(i < K){
                System.out.println(chars[4*K-i]+spaceStr+chars[K+i]);
            }else{
                System.out.println(new StringBuilder(str.substring(2*K,3*K+1)).reverse().toString());
            }
        }
    }





}
