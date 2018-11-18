public class minLine {
    public static void main(String[] args){

        int[][] martix = new int[3][6];
        martix = new int[][]{{1, 3, 3, 4, 5, 6}, {0, 2, 3, 5, 4, 6}, {4, 3, 2, 3, 5, 6}};
        String[][] mmartix = new String[4][7];
        for (int i = 0;i<4;i++){
            mmartix[i][0] = null;
        }
        for (int i = 0;i<7;i++){
            mmartix[0][i] = null;
        }
        int start = martix[1][1];
        for (int i = 0;i<3;i++){
            for (int j = 0;j<6;j++){
                martix[i][j] =  Math.min(Math.min(martix[i][j+1],martix[i+1][j+1]),martix[i+1][j]);
                if (start == martix[i][j+1]) mmartix[i+1][j+1] = "->";
                if (start == martix[i+1][j+1]) mmartix[i+1][j+1] = "V";
                else mmartix[i+1][j+1] = "xie";
            }
        }
        System.out.println(mmartix);

    }
}
