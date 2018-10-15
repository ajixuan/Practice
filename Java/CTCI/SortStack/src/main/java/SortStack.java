import java.util.ArrayDeque;
import java.util.Deque;

public class SortStack {

    private Deque<Integer> stack;
    private Deque<Integer> temp;

    public SortStack(){
        stack = new ArrayDeque<>();
        temp = new ArrayDeque<>();
    }

    public int pop(){
        return 0;
    }

    public void push(int val){}

    public int peek(){
        return 0;
    }

    public boolean isEmpty(){
        return true;
    }


}
