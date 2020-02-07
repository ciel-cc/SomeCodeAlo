import java.util.Arrays;

public class MarioJump {
    public int marioDump(int[] maxDis, int p){
        int[] dp = new int[maxDis.length];
        //往后跳可达,
        for (int i = maxDis.length-1; i >=0; i--) {
            if (maxDis[i] == 0)
                dp[i] = -1;
            else if (i+maxDis[i] >= maxDis.length)
                dp[i] = 1;
            else{
                int min = Integer.MAX_VALUE;
                for (int j = i+1 ; j < (i+maxDis[i]+1); j++) {
                    if (dp[j] != -1)
                        min = Math.min(dp[j], min);
                }
                if (min == Integer.MAX_VALUE)
                    dp[i] = -1;
                else
                    dp[i] = min + 1;
            }
        }
        System.out.println(Arrays.toString(dp));
        //往前跳可达
        for (int i = 0; i < maxDis.length; i++) {
            if (maxDis[i] == 0)
                dp[i] = -1;
            else if (dp[i] == 1)
                continue;
            else {
                int min = Integer.MAX_VALUE;
                for (int j = Math.max(i-maxDis[i], 0) ; j < i ; j++) {
                    if (dp[j] != -1)
                        min = Math.min(dp[j], min);
                }
                if (min != Integer.MAX_VALUE){
                    dp[i] = ( dp[i] == -1 ) ? min+1 : Math.min(dp[i], min+1);
                }
            }
        }
        System.out.println(Arrays.toString(dp));
        return dp[p-1];
    }

    public static void main(String[] args) {

        int[] maxDis = new int[]{10,0,2,1,1,0,1};
        System.out.println(new MarioJump().marioDump(maxDis, 2));
    }
}
