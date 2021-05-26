package Sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class XiEr {
    public static void main(String[] args) {
        int[] arr = {8,9,1,7,2,3,5,4,6,0};
        XE1(arr);
        System.out.println(Arrays.toString(arr));
        XE2(arr);
        System.out.println(Arrays.toString(arr));

        int[] arr_test=new int[80000];
        for (int i = 0;i<arr_test.length;i++){
            arr_test[i] = (int)(Math.random()*100000);
        }
        Date date1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd,HH:mm:ss");
        String date1str = simpleDateFormat.format(date1);
        System.out.println(date1str);
        XE1(arr_test);
//        System.out.println(Arrays.toString(arr_test));
        Date date2 = new Date();
        String date2str = simpleDateFormat.format(date2);
        System.out.println(date2str);
        System.out.println(Arrays.toString(arr_test));


    }
    public static void XE1(int[] arr){
        int temp;
        for(int gap = arr.length/2;gap>0;gap /=2){
            for(int i = gap;i<arr.length;i++){
                for(int j = i-gap;j>=0;j -=gap){
                    if(arr[j]>arr[j+gap]){
                        temp = arr[j+gap];
                        arr[j+gap]=arr[j];
                        arr[j]=temp;
                    }
                }
            }
        }
    }

    public static void XE2(int[] arr){
        int temp;
        for (int gap = arr.length/2;gap>0;gap /= 2){
            for (int i = gap; i<arr.length;i++){
                int index = i;
                temp = arr[index];
                while ((index - gap)>=0&&temp<arr[index-gap]){
                    arr[index]=arr[index - gap];
                    index -= gap;
                }
                arr[index] = temp;
            }
        }
    }
}
