package Sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class XuanZe {
    public static void main(String[] args) {
//        int[] arr = {-1, 3, 0, -5, 9};

        int[] arr_test=new int[80000];
        for (int i = 0;i<arr_test.length;i++){
            arr_test[i] = (int)(Math.random()*100000);
        }

        Date date1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd,HH:mm:ss");
        String date1str = simpleDateFormat.format(date1);
        System.out.println(date1str);
        XZ(arr_test);
//        System.out.println(Arrays.toString(arr_test));

        Date date2 = new Date();
        String date2str = simpleDateFormat.format(date2);
        System.out.println(date2str);
    }


    public static void XZ(int[] arr) {

        int count =0;
        boolean flag = false;

        for (int i = 0; i < arr.length - 1; i++) {
            count++;
            int temp_index = i;
            int temp = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < temp) {
                    temp_index = j;
                    temp = arr[j];
                }
            }
            if (temp_index != i){
                arr[temp_index] = arr[i];
                arr[i] = temp;

            }else{
                break;
            }

        }
//        System.out.println(count);
    }
}
