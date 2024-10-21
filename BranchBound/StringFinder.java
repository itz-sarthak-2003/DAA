import java.io.*;
        import java.util.*;

class StringFinder {

    // Function to find all subsets starting from index 'ind'
    public static void findSubsets(int ind, int[] nums, ArrayList<Integer> currentSet, ArrayList<ArrayList<Integer>> allSubsets) {
        // Add the current subset to the list of all subsets
        allSubsets.add(new ArrayList<>(currentSet));

        // Loop through the array and find more subsets
        for (int i = ind; i < nums.length; i++) {
            // Skip duplicates (to avoid repeating the same subset)
            if (i != ind && nums[i] == nums[i - 1]) {
                continue;
            }

            // Include the current number in the subset
            currentSet.add(nums[i]);
            // Recursively find more subsets by considering the next elements
            findSubsets(i + 1, nums, currentSet, allSubsets);
            // Remove the current number to explore other subsets
            currentSet.remove(currentSet.size() - 1);
        }
    }

    // Function to find all unique subsets of a given array
    public static ArrayList<ArrayList<Integer>> getAllSubsets(int[] arr, int n) {
        // Sort the array to handle duplicates
        Arrays.sort(arr);

        // List to store all subsets
        ArrayList<ArrayList<Integer>> allSubsets = new ArrayList<>();

        // Find subsets starting from index 0
        findSubsets(0, arr, new ArrayList<>(), allSubsets);

        return allSubsets;
    }

    // Main function to run the program
    public static void main(String[] args) {
        int[] set = { 10, 12, 12 }; // The given set of numbers
        System.out.println(getAllSubsets(set, 3)); // Print all unique subsets
    }
}

