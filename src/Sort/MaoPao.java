package Sort;

import java.lang.reflect.Array;
import java.util.Arrays;

public class MaoPao {
    public static void main(String[] args) {
        int[] arr = {-1,3,-4,10,9};
        int temp =0;
        boolean flag = false;
        for (int i =0;i<arr.length-1;i++){
            for (int j = 0;j<arr.length-1-i;j++){
                if (arr[j] > arr[j+1]){
                    flag = true;
                    temp =arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1] = temp;
                }
            }
            if(!flag){
                break;
            }else {
                flag = false;
            }
        }
        System.out.println(Arrays.toString(arr));


    }


}
