import java.util.*;
import java.util.stream.IntStream;

public class FindNDuplicate {

    private int[] list;

    /**
     * FindNDuplicate
     * adding extra duplicates results in 1 + dupes number of duplicates
     *
     * @param n
     * @param dupes
     */
    public FindNDuplicate(int n, int dupes){
        if (dupes < 0) {
            throw new RuntimeException("Duplicates must be >= 0");
        } else if (dupes > n / 2) {
            throw new RuntimeException("Duplicates cannot be > n/2");
        }

        this.list = FindNDuplicate.makeList(n);
        Random r = new Random();

        //There is always one duplicate in every list
        dupes--;
        if(dupes <= 0) return;
        int bound = (n > 2)? n - 1 : 1;
        Set<Integer> taken = new HashSet<>();
        taken.add(this.list[n]);
        int index = r.nextInt(bound);
        int val = r.nextInt(bound);
        while (dupes > 0) {
            while(taken.contains(index)){
                index = r.nextInt(bound);
            }

            while (taken.contains(val) || index == val) {
                val = r.nextInt(bound);
            }

            this.list[index] = val;
            taken.add(index);
            taken.add(val);
            dupes--;
        }

    }

    /**
     * FindNDuplicate
     * Creates a list that will have only 1 duplicate
     *
     * @param n
     */
    public FindNDuplicate(int n) {
        this.list = FindNDuplicate.makeList(n);
    }


    private static int[] makeList(int n) {
        int[] list = new int[n + 1];
        for (int i = 0; i < n; i++) {
            list[i] = i;
        }

        Random r = new Random();
        IntStream indexes = r.ints(0, n).distinct();
        list[n] = list[indexes.findAny().getAsInt()];
        return list;
    }

    public int[] getList() {
        return this.list;
    }

    /**
     * findDupes()
     * Finds all the duplicates in the list and returns them
     * The negative method uses the negative value to indicate that the current index have once
     * been checked, which implies that previously another element had the same value. So when a
     * negative number is encountered, it implies that the value that lead to this index is duplicate.
     *
     * Algorithm:
     *   - Iterate through list
     *   - Use the element's value as index, recursively set the element at that index to negative
     *   - Stop when negative number is found or when the elements points back to current index
     *   - If negative number is found then append current number to solution
     *
     * @return A list of duplicates
     */
    public HashSet<Integer> findDupesByNegatives() {
        //Set values to negative to indicate duplicate
        HashSet<Integer> sol = new HashSet<>();
        int check;

        for(int i = 0; i < this.list.length; i++){
            check = this.list[i];

            //First check cannot be negative
            if(check < 0) {
                check = Math.abs(check) - 1;
            }

            if(this.list[check] < 0){
                sol.add(check);
                continue;
            }

            this.list[check] = -1 - this.list[check];
        }

        //Restore the list
        for(int i = 0 ; i < this.list.length; i++){
            this.list[i] = Math.abs(this.list[i]) - 1;
        }

        System.out.println(sol.toString());
        return sol;

    }

    public void printList() {
        for (int i : this.list) {
            System.out.printf("%d,", i);
        }
        System.out.print("\n");

    }

}
