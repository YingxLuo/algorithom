package Recurrence;

public class MiGong {
    public static void main(String[] args) {
        //初始化迷宫
        //1代表墙，2代表当前格子可走，3代表当前格子开始为死路
        int[][] map = new int[8][7];
        for (int i = 0; i < 7; i++) {
            map[0][i] = 1;
            map[7][i] = 1;
        }
        for (int i = 0; i < 8; i++) {
            map[i][0] = 1;
            map[i][6] = 1;
        }
        map[3][1] = 1;
        map[3][2] = 1;
        map[2][2] = 1;
        map[3][3] = 1;
//        map[1][3] = 1;


        boolean isfind = setWay(map,1,1);
        if (isfind == true){
            System.out.println("找到了");
        }else{
            System.out.println("没有路");
        }
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * @param map 迷宫地图
     * @param i   起始坐标
     * @param j
     * @return 迷宫从(i, j)开始，到达(6,5)为止
     * 搜寻策略，下-右-上-左
     */
    public static boolean setWay(int[][] map, int i, int j) {
        if (map[6][5] == 2) {
            return true;
        } else {
            if (map[i][j] == 0) {
                map[i][j] = 2;
                if (setWay(map, i + 1, j)) {
                    return true;
                } else if (setWay(map, i, j + 1)) {
                    return true;
                } else if (setWay(map, i - 1, j)) {
                    return true;
                } else if(setWay(map, i, j - 1)) {
                    return true;
                } else {
                    map[i][j] = 3;  //如果都走不通说明是死路，而且运行到这里一定是靠墙的点或者是中间的点递归回溯了
                    return false;
                }
            }else{
                return false;//可能是1，2，3
            }


        }
    }
}


