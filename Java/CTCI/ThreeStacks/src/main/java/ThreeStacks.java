public class ThreeStacks <E>{
    private Object[] array;
    private int[] heads;
    private int[] tails;
    private int stacks;
    public int test;

    public ThreeStacks(int len, int stacks) {
        if(len <= 0 || stacks <= 0)
            throw new IllegalArgumentException("Length or number of stacks must be greater than 0");
        this.array = new Object[len];
        this.heads = new int[stacks];
        this.tails = new int[stacks];
        this.stacks = stacks;

        //Initialize each stack position
        int div = len / stacks;
        for(int i = 0; i < this.stacks; i++){
            this.heads[i] = div * i;
            this.tails[i] = div * i;
        }
    }

    public E pop(int stack, E obj){

        return null;
    }

    public void push(int stack, E obj){
        if(stack >= this.stacks) {
            String err = "The stack number:" + stack + "does not exist for this stack size " + this.stacks;
            throw new IndexOutOfBoundsException(err);
        }

        int nextStack = (stack + 1) % this.heads.length;
        if(_getTail(stack) == heads[nextStack])
            shuffle(stack+1, 0);
        this.array[tails[stack]+1] = obj;
        tails[stack]++;
    }

    public boolean isEmpty(int stack){
        if(heads[stack] == tails[stack] && array[tails[stack]] == null){
            return true;
        }
        return false;
    }


    /**
     * _getTail
     *  Method for getting the tail of stacks
     *  This method treats the array as circular
     * @return
     */
    private int _getTail(int stack){
        return this.tails[stack] % this.array.length;
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

        if(_getTail(stack) == this.heads[stack+1]){
            this.shuffle(stack+1, level+1);
        }

        //Shift all elements of stack
        for(int i = this.tails[stack]; i >= this.heads[stack]; i--){
            this.array[i + 1 % this.array.length] = this.array[i];
        }
    }
}
