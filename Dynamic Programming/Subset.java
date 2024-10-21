import java.io.*;
class Subset{

    // This method checks if there is a subset of the array
    // that adds up to the target sum
    static boolean isSubsetSum(int[] set, int n, int sum) {
        // If the sum becomes 0, it means we found a subset
        if (sum == 0)
            return true;

        // If we run out of numbers and haven't found the sum, return false
        if (n == 0)
            return false;

        // If the current number is bigger than the sum, ignore it
        if (set[n - 1] > sum)
            return isSubsetSum(set, n - 1, sum);

        // Otherwise, check two possibilities:
        // (a) Including the current number in the subset
        // (b) Not including the current number in the subset
        return isSubsetSum(set, n - 1, sum) || isSubsetSum(set, n - 1, sum - set[n - 1]);
    }

    // This is the main method that runs the program
    public static void main(String[] args) {
        int[] set = {3, 34, 4, 12, 5, 2}; // The array of numbers
        int sum = 9; // The target sum we want to check for
        int n = set.length; // The number of elements in the array

        // Check if we can find a subset with the given sum
        if (isSubsetSum(set, n, sum))
            System.out.println("Found a subset with the given sum");
        else
            System.out.println("No subset with the given sum");
    }
}
