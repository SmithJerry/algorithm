package company.test01;

import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 *
 */
public class Main1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in = new StreamTokenizer(br);
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        while (in.nextToken() != StreamTokenizer.TT_EOF){
            int N = (int) in.nval;
            in.nextToken();
            int M = (int) in.nval;

            int[][] matrix = new int[M][3];

            for(int i = 0; i < M; i++){
                in.nextToken();
                matrix[i][0] = (int) in.nval;
                in.nextToken();
                matrix[i][1] = (int) in.nval;
                in.nextToken();
                matrix[i][2] = (int) in.nval;
            }

            System.out.println(N + "/t" + M + "/t");
            for(int i = 0; i < M; i++){
                for (int j = 0; j < 3; j++){
                    System.out.print(matrix[i][j]);
                }
                System.out.println();
            }
        }

        PriorityQueue<Integer[]> queue = new PriorityQueue<>(new Comparator<Integer[]>() {
            @Override
            public int compare(Integer[] o1, Integer[] o2) {
                return o1[1] - o2[1];
            }
        });



    }
}
