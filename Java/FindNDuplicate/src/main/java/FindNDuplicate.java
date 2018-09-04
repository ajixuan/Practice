import java.util.Random;
import java.util.stream.IntStream;

public class FindNDuplicate {

    private int[] list;

    /**
     * FindNDuplicate
     *   adding extra duplicates results in 1 + moreDupes number of duplicates
     * @param n
     * @param moreDupes
     */
    public FindNDuplicate(int n, int moreDupes) {
        if (moreDupes < 0) {
            throw new RuntimeException("Duplicates must be >= 0");
        }

        this.list = FindNDuplicate.makeList(n);
        Random r = new Random();
        IntStream distinct = r.ints(n * 4, 0, n).distinct();
        IntStream indexes = r.ints(0, n).distinct();
        while (moreDupes > 0) {
            list[indexes.findAny().getAsInt()] = distinct.findAny().getAsInt();
            moreDupes--;
        }
    }

    /**
     * FindNDuplicate
     *   Creates a list that will have only 1 duplicate
     * @param n
     */
    public FindNDuplicate(int n){
        this.list = FindNDuplicate.makeList(n);
    }
    
    
    private static int[] makeList(int n){
        int[] list = new int[n + 1];
        for (int i = 0; i < n; i++) {
            list[i] = i;
        }

        Random r = new Random();
        IntStream indexes = r.ints(0, n).distinct();
        list[n] = list[indexes.findAny().getAsInt()];
        return list;
    }
    
    
    public int[] getList(){
        return this.list;
    }

}
