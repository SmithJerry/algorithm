package base.class40;

/**
 * @author Liang
 * @date 2023/7/30 - 20:54
 */
public class PrintMatrixSpiralOrder {

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20}};

        spiralOrderPrint(matrix);
    }

    private static void spiralOrderPrint(int[][] matrix) {
        int tR = 0;
        int tC = 0;
        int dR = matrix.length - 1;
        int dC = matrix[0].length - 1;
        while (tR <= dR && tC <= dC){
            printMatrix(matrix, tR++, tC++, dR--, dC--);
        }
    }

    private static void printMatrix(int[][] matrix, int tR, int tC, int dR, int dC) {
        if(tR == dR){
            for (int i = tC; tC <= dC; tC++){
                System.out.print(matrix[tR][i]);
            }
        }else if(tC == dC){
            for(int i = tR; tR <= dR; tR++){
                System.out.print(matrix[i][tC]);
            }
            System.out.println();
        }else {
            int curR = tR;
            int curC = tC;
            while (curC != dC){
                System.out.print(matrix[curR][curC++]);
            }
            while (curR != dR){
                System.out.print(matrix[curR++][curC]);
            }
            while (curC != tC){
                System.out.print(matrix[curR][curC--]);
            }
            while (curR != tR){
                System.out.print(matrix[curR--][curC]);
            }
        }
    }
}
