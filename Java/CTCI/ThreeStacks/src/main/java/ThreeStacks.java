import java.util.EmptyStackException;

public class ThreeStacks <E>{
    private Object[] array;
    private int[] heads;
    private int[] tails;
    private int stacks;

    public ThreeStacks(int len, int stacks) {
        if(len <= 0 || stacks <= 0)
            throw new IllegalArgumentException("Length or number of stacks must be greater than 0");
        this.array = new Object[len];
        heads = new int[stacks];
        tails = new int[stacks];
        this.stacks = stacks;

        //Initialize each stack position
        int div = len / stacks;
        for(int i = 0; i < this.stacks; i++){
            heads[i] = div * i;
            tails[i] = div * i;
        }
    }

    public E pop(int stack){
        E val = (E) this.array[_tail(stack)];
        this.array[_tail(stack)] = null;
        if(val == null) throw new EmptyStackException();
        if(tails[stack] != heads[stack]) tails[stack]--;
        return val;
    }

    public void push(int stack, E obj){
        if(stack >= this.stacks) {
            String err = "The stack number:" + stack + "does not exist for this stack size " + this.stacks;
            throw new IndexOutOfBoundsException(err);
        }

        if(isEmpty(stack)) {
            this.array[tails[stack]] = obj;
            return;
        }

        int nextStack = (stack + 1) % this.stacks;
        if((_tail(stack) + 1) % this.array.length == _head(nextStack))
            shuffle(nextStack, 0);
        this.array[(_tail(stack) + 1) % this.array.length] = obj;
        tails[stack]++;
    }

    public boolean isEmpty(int stack){
        if(array[tails[stack]] == null){
            return true;
        }
        return false;
    }


    /**
     * _tail
     *  Method for getting the tail of stacks
     *  This method treats the array as circular
     * @return
     */
    private int _tail(int stack){
        return tails[stack] % this.array.length;
    }

    /**
     * _head
     *  Method for getting the head of stacks
     *  This method treats the array as circular
     * @return
     */
    private int _head(int stack){
        return heads[stack] % this.array.length;
    }

    /**
     * shuffle
     *  Recursively move all elements of stack forward by 1
     *  Can wrap to the beginning of array
     * @param stack
     * @param level
     *
     */
    private void shuffle(int stack, int level){
        if(level == this.stacks){
            //Stack is completely full
            throw new StackOverflowError("The stack is full");
        }

        int nextStack = (stack + 1) % this.stacks;
        if((_tail(stack) + 1) % this.array.length == _head(nextStack)){
            this.shuffle(nextStack, level + 1);
        }

        //Shift all elements of stack
        for(int i = tails[stack]; i >= heads[stack]; i--){
            this.array[(i + 1) % this.array.length] = this.array[i % this.array.length];
        }
        heads[stack]++;
        tails[stack]++;
    }
}
