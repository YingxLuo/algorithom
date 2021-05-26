package Sort;

import java.util.Arrays;

public class ChaRu {
    public static void main(String[] args) {
        int[] arr={0,-1,-2,-4,5};
        CR(arr);
//        System.out.println(Arrays.toString(arr));
    }
    public static void CR(int[] arr){
        int count =0;
        for (int index = 1;index<arr.length;index++){
            int i = index;
            int temp = arr[i];

            while((i-1) >= 0 && temp < arr[i-1]){
                arr[i] = arr[i -1];
                i --;
            }

            arr[i]= temp;

            System.out.println("第"+index+"轮排序结果："+Arrays.toString(arr));

        }
    }
}
