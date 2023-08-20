package base.class19;

/**
 * @author Liang
 * @date 2023/7/23 - 13:00
 */
public class LongestCommonSubsequence {
    public static int longestCommonSubsequence(String s1, String s2){
        if(s1 == null || s2 == null || s1.length() == 0 || s2.length() == 0){
            return 0;
        }

        char[] str1 = s1.toCharArray();
        char[] str2 = s2.toCharArray();

        return process(str1, str2, str1.length - 1, str2.length - 1);


    }

    private static int process(char[] str1, char[] str2, int len1, int len2) {

        if(len1 == 0 && len2 == 0){
            return str1[len1] == str2[len1] ? 1 : 0;
        }else if(len1 == 0){
            if(str1[len1] == str2[len2]){
                return 1;
            }else {
                return process(str1, str2, len1, len2 - 1);
            }
        }else if(len2 == 0){
            if(str1[len1] == str2[len2]){
                return 1;
            }else {
                return process(str1, str2, len1 - 1, len2);
            }
        }else {
            int p1 = process(str1, str2, len1 -1, len2);
            int p2 = process(str1, str2, len1, len2 - 1);
            int p3 = str1[len1] == str2[len2] ? (process(str1, str2, len1 - 1, len2 - 1) + 1) : 0;

            return Math.max(p1, Math.max(p2, p3));
        }

    }

    public static int longestCommonSubsequence2(String s1, String s2){
        if(s1 == null || s2 == null || s1.length() == 0 || s2.length() == 0){
            return 0;
        }

        char[] str1 = s1.toCharArray();
        char[] str2 = s2.toCharArray();

        int N = str1.length;
        int M = str2.length;
        int[][] dp = new int[N][M];
        dp[0][0] = str1[0] == str2[0] ? 1 : 0;
        for(int i = 1; i < N; i++){
            dp[i][0] = str1[i] == str2[0] ? 1 : dp[i - 1][0];
        }

        for (int j = 1; j < M; j++){
            dp[0][j] = str1[0] == str2[j] ? 1 : dp[0][j - 1];
        }

        for(int i = 1; i < N; i++){
            for(int j = 1; j < M; j++){
                int p1 = dp[i][j - 1];
                int p2 = dp[i - 1][j];
                int p3 = str1[i] == str2[j] ? (dp[i - 1][j - 1] + 1) : 0;

                dp[i][j] = Math.max(p1, Math.max(p2, p3));
            }
        }

        return dp[N - 1][M - 1];
    }
}
