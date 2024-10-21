
import java.io.*;

class ConversionStr {

    // Function to check if we can convert string s1 to string s2
    static boolean check(String s1, String s2) {
        int n = s1.length(); // length of s1
        int m = s2.length(); // length of s2

        // Create a 2D table to track if conversion is possible
        boolean[][] dp = new boolean[n + 1][m + 1];

        // Initialize all positions in the table to false
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                dp[i][j] = false;
            }
        }

        // Set the first position as true because empty strings match
        dp[0][0] = true;

        // Go through every character in s1
        for (int i = 0; i < n; i++) {
            // Try to match it with every character in s2
            for (int j = 0; j <= m; j++) {
                if (dp[i][j]) {
                    // If s1[i] (uppercase) matches s2[j], move to the next character
                    if (j < m && Character.toUpperCase(s1.charAt(i)) == s2.charAt(j)) {
                        dp[i + 1][j + 1] = true;
                    }

                    // If s1[i] is lowercase, we can "delete" it and continue
                    if (!Character.isUpperCase(s1.charAt(i))) {
                        dp[i + 1][j] = true;
                    }
                }
            }
        }

        // Return whether we can convert the entire s1 to s2
        return dp[n][m];
    }

    // Main method to run the program
    public static void main(String[] args) {
        String s1 = "daBcd"; // The first string
        String s2 = "ABC";   // The second string

        // Check if we can convert s1 to s2 and print the result
        if (check(s1, s2)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
