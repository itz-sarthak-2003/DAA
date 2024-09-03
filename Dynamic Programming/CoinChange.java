import java.util.Arrays;
class CoinChange {
    static long count(int coins[], int n, int sum)
{
    int dp[] = new int[sum + 1];
    dp[0] = 1;
    for (int i = 0; i < n; i++)
        for (int j = coins[i]; j <= sum; j++)
            dp[j] += dp[j - coins[i]];

    return dp[sum];
}
    public static void main(String args[])
    {
        int coins[] = { 1, 2 };
        int n = coins.length;
        int sum = 2;
        System.out.println(count(coins, n, sum));
    }
}
