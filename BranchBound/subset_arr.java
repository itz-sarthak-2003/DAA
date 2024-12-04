import java.util.*;

class SubsetGenerator {

    // Function to find all subsets of the given array
    public static void generateSubsets(int[] array) {
        // Get the length of the input array
        int arrayLength = array.length;

        // Loop through all possible subsets using bit manipulation
        for (int subsetMask = 0; subsetMask < (1 << arrayLength); subsetMask++) {
            // Loop through all elements of the input array
            for (int index = 0; index < arrayLength; index++) {
                // Check if the index-th bit is set in the current subset mask
                if ((subsetMask & (1 << index)) != 0) {
                    // If the bit is set, include the corresponding element in the subset
                    System.out.print(array[index] + " ");
                }
            }
            // Move to the next line after printing a subset
            System.out.println();
        }
    }

    // Main function to test the subset generator
    public static void main(String[] args) {
        int[] numbers = { 1, 2, 3 }; // Input array
        generateSubsets(numbers);    // Generate and print subsets
    }
}