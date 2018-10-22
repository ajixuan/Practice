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
        return stack.pop();
    }

    /**
     * Push
     *  - Check if current val is less than top
     *  - If less than top, push onto top
     *  - If greater than top, push top onto temp, repeat compare
     *  - Restore stack order
     * @param val
     */
    public void push(int val){
        if(stack.isEmpty()) {
            stack.push(val);
            return;
        }

        while(!stack.isEmpty() && stack.peek() < val){
            temp.push(stack.pop());
        }

        stack.push(val);

        while(!temp.isEmpty()){
            stack.push(temp.pop());
        }
    }

    public int peek(){
        return stack.peek();
    }

    public boolean isEmpty(){
        return (stack.size() == 0);
    }


}
