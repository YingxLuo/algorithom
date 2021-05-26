package Recurrence;

public class Queen8 {
    public static void main(String[] args) {
        Queen8 queen8 = new Queen8();
        queen8.putin(0);
    }

    int MAX_QUEEN = 8;
    int SIZE = 8;
    //arr[8]=[5,1,3,6,2,4,6,7]，5代表棋盘坐标（0，5）...
    int[] arr = new int[MAX_QUEEN];

    private void putin(int n) {
        if (n == MAX_QUEEN) {
//            System.out.println("**********");
            print_queen();
            return;
            //这里输出一个后，返回到上一级，执行arr[n]=i，查看在其他皇后位置不变情况下，当前还有无其他解法
            //若没有，这一层的putin方法自动结束，回溯到上一层，调整倒数第二层皇后一个位置，然后又往下走，来回反复

        }

        for (int i = 0; i < SIZE; i++) {
            arr[n] = i;
//            System.out.println("######");
            //不冲突的话，就接着放
            if (judge(n)) {
                putin(n + 1);
//                System.out.println("*******");
            }
            //冲突的话，就执行arr[n]=i，这里i已经+1了
        }
    }

    /**
     * 判断第n个皇后是否与之前冲突
     *
     * @param n 第n个皇后，相当于行数
     * @return
     */
    private boolean judge(int n) {
        //i代表列数，
        //arr[i]代表第i个皇后所在的列数
        //arr[n]代表第n个皇后所在的列数
        for (int i = 0; i < n; i++) {
            if (arr[i] == arr[n] || Math.abs(n - i) == Math.abs(arr[n] - arr[i])) {
                return false;
            }
        }
        return true;
    }

    private void print_queen() {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

}
