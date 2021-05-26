package Recurrence_Test;

public class Migong {
    public static void main(String[] args) {
        int[][] map = new int[7][8];
        for(int i=0;i<8;i++ ){
            map[0][i]=1;
            map[6][i]=1;
        }
        for(int i=0;i<7;i++ ){
            map[i][0]=1;
            map[i][7]=1;
        }

        map[2][3]=1;
        map[3][3]=1;
        map[3][2]=1;
        map[3][1]=1;

        findway(map,1,1);
        print_map(map);
    }


    public static boolean findway(int[][] map,int i ,int j){
        if (map[5][6]==2){
            return true;
        }else{
            if(map[i][j] == 0){
                map[i][j]=2;
                if(findway(map,i,j+1)){
                    return true;
                }else if ( findway(map,i+1,j)){
                    return true;

                }else if ( findway(map,i-1,j)){
                    return true;

                }else if (findway(map,i,j-1)){
                    return true;

                }else {
                    map[i][j]=3;
                    return false;
                }

            } else{
                return false;
            }
        }
    }


    public static void print_map(int[][] map){
        for (int i = 0 ;i<7;i++){
            for (int j = 0;j<8;j++){
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
    }

}
