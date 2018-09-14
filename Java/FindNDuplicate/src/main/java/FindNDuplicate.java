import java.util.*;
import java.util.stream.IntStream;

public class FindNDuplicate {

    private int[] list;

    /**
     * FindNDuplicate
     * adding extra duplicates results in 1 + moreDupes number of duplicates
     *
     * @param n
     * @param moreDupes
     */
    public FindNDuplicate(int n, int moreDupes) {
        if (moreDupes < 0) {
            throw new RuntimeException("Duplicates must be >= 0");
        } else if (moreDupes > n / 2) {
            throw new RuntimeException("Duplicates cannot be > n/2");
        }

        this.list = FindNDuplicate.makeList(n);
        Random r = new Random();

        int bound = (n > 2)? n - 2 : 1;

        int[] randoms = r.ints(0, n).distinct().limit(moreDupes).sorted().toArray();
        Set<Integer> taken = new HashSet<Integer>();

        int index = r.nextInt(bound);
        while (moreDupes > 0) {
            while (taken.contains(index)) {
                index = r.nextInt(bound);
            }
            index = (index % 2 == 1) ? index + 1 : index;
            this.list[index] = randoms[moreDupes - 1];
            this.list[index + 1] = randoms[moreDupes - 1];
            moreDupes--;
            taken.add(index);
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
     *
     * @return A list of duplicates
     */
    public List findDupes() {
        //Divide and conquer
        System.out.println(list.toString());
        return null;

    }

    public void printList() {
        for (int i : this.list) {
            System.out.printf("%d,", i);
        }
        System.out.print("\n");

    }

}
