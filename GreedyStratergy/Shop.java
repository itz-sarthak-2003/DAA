package daa;

import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeSet;

class Shop
{
    public static int maximumShops(int[] opening, int[] closing, int n, int k)
    {

        // Store opening and closing time of shops
        Pair[] a = new Pair[n];
        for (int i = 0; i < n; i++) {
            a[i] = new Pair(opening[i], closing[i]);
        }

        // Sort the pair of array
        Arrays.sort(a, new Comparator<Pair>() {
            @Override
            public int compare(Pair a, Pair b) {
                if (a.second != b.second) {
                    return a.second - b.second;
                }
                return a.first - b.first;
            }
        });

        // Stores the result
        int count = 0;

        // Stores current number of persons visiting
        // some shop with their ending time
        TreeSet<Integer> st = new TreeSet<>();

        for (int i = 0; i < n; i++)
        {

            // Check if current shop can be assigned to
            // a person who's already visiting any other shop
            boolean flag = false;

            if (!st.isEmpty()) {
                Integer it = st.higher(a[i].first);
                if (it != null && it <= a[i].first)
                {

                    // Erase previous shop visited by
                    // the person satisfying the condition
                    st.remove(it);

                    // Insert new closing time of current shop
                    // for the person satisfying ?he condition
                    st.add(a[i].second);

                    // Increment the count by one
                    count++;
                    flag = true;
                }
            }

            // In case if no person have
            // closing time <= current shop opening time
            // but there are some persons left
            if (st.size() < k && flag == false) {
                st.add(a[i].second);
                count++;
            }
        }

        // Finally return the ans
        return count+1;
    }

    public static void main(String[] args)
    {

        // Given starting and ending time
        int S[] = {1, 8, 3, 2, 6};
        int E[] = {5, 10, 6, 5, 9};

        // Given K and N
        int K = 2, N = S.length;

        // Function call
        System.out.println(maximumShops(S, E, N, K));
    }
    static class Pair {
        public int first;
        public int second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

}

// This code is contributed by aadityaburujwale.
