package daa;

public class CountZeroes {
    // Function to find the first occurrence of 0 using binary search
    public static int findFirstZero(int[] arr, int low, int high) {
        if (high >= low) {
            int mid = low + (high - low) / 2;

            // Check if the mid element is the first 0
            if ((mid == 0 || arr[mid - 1] == 1) && arr[mid] == 0) {
                return mid;
            }

            // If the mid element is 1, search in the right half
            if (arr[mid] == 1) {
                return findFirstZero(arr, mid + 1, high);
            } else { // Search in the left half
                return findFirstZero(arr, low, mid - 1);
            }
        }
        return -1; // Return -1 if no zeroes are found
    }

    // Function to count the number of zeroes in the array
    public static int countZeroes(int[] arr) {
        int n = arr.length;
        int firstZeroIndex = findFirstZero(arr, 0, n - 1);

        if (firstZeroIndex == -1) {
            return 0; // No zeroes found
        }

        // Number of zeroes is the total length of the array minus the index of the first 0
        return n - firstZeroIndex;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 1, 1, 1, 0, 0};
        int[] arr2 = {1, 0, 0, 0, 0};

        System.out.println("Number of zeroes in arr1: " + countZeroes(arr1)); // Output: 2
        System.out.println("Number of zeroes in arr2: " + countZeroes(arr2)); // Output: 4
    }
}
