package daa;

public class SmallNoTrailing0 {public static int countTrailingZeroes(int number) {
    int count = 0;
    for (int i = 5; number / i >= 1; i *= 5) {
        count += number / i;
    }
    return count;
}

    // Function to find the smallest number whose factorial contains at least n trailing zeroes
    public static int findSmallestNumber(int n) {
        if (n == 0) return 0;

        // Initialize binary search boundaries
        int low = 0;
        int high = 5 * n; // Upper bound estimate

        // Binary search for the smallest number with at least n trailing zeroes
        while (low < high) {
            int mid = low + (high - low) / 2;
            int count = countTrailingZeroes(mid);

            if (count < n) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return low;
    }

    public static void main(String[] args) {
        int n1 = 1;
        int n2 = 6;

        System.out.println("Smallest number with at least " + n1 + " trailing zeroes: " + findSmallestNumber(n1)); // Output: 5
        System.out.println("Smallest number with at least " + n2 + " trailing zeroes: " + findSmallestNumber(n2)); // Output: 25
    }
}
