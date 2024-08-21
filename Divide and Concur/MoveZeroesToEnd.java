package daa;

public class MoveZeroesToEnd {
    // Function to move all zeroes to end using divide and conquer
    public static void moveZeroes(int[] arr, int left, int right) {
        // Base case: If the segment has 1 or 0 elements, return
        if (left >= right) {
            return;
        }

        // Find the middle index
        int mid = left + (right - left) / 2;

        // Recursively sort both halves
        moveZeroes(arr, left, mid);
        moveZeroes(arr, mid + 1, right);

        // Merge the two halves and move zeroes to the end
        mergeAndMoveZeroes(arr, left, mid, right);
    }

    // Function to merge two halves and move zeroes to the end
    public static void mergeAndMoveZeroes(int[] arr, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int index = 0;

        // Add all non-zero elements from the left half
        for (int i = left; i <= mid; i++) {
            if (arr[i] != 0) {
                temp[index++] = arr[i];
            }
        }

        // Add all non-zero elements from the right half
        for (int i = mid + 1; i <= right; i++) {
            if (arr[i] != 0) {
                temp[index++] = arr[i];
            }
        }

        // Fill the remaining part with zeroes
        while (index < temp.length) {
            temp[index++] = 0;
        }

        // Copy the merged result back to the original array
        for (int i = left; i <= right; i++) {
            arr[i] = temp[i - left];
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 9, 8, 4, 0, 0, 2, 7, 0, 6, 0};

        moveZeroes(arr, 0, arr.length - 1);

        // Print the modified array
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
