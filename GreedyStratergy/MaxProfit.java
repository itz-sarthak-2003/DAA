package daa;// Java program for the above approach
import java.io.*;
public class MaxProfit{

    // Function to find the maximum profit
    static int maxProfit(int[] prices, int n)
    {
        int profit = 0, currentDay = n - 1;

        // Start from the last day
        while (currentDay > 0)
        {
            int day = currentDay - 1;

            while (day >= 0 &&
                    (prices[currentDay] > prices[day]))
            {
                profit += (prices[currentDay] -
                        prices[day]);

                day--;
            }

            // Set this day as currentDay
            // with maximum cost of stock
            // currently
            currentDay = day;
        }

        // Return the profit
        return profit;
    }

    // Driver Code
    public static void main(String[] args)
    {
        // Given array of prices
        int prices[] = { 2, 3, 5 };

        int N = prices.length;

        // Function Call
        System.out.print(maxProfit(prices, N));
    }
}

