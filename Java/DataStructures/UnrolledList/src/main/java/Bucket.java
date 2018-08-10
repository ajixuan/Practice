public class Bucket<E> {
    public Bucket next;
    public Bucket prev;
    private Item head;
    private Item tail;

    private int max;
    private int size;

    private class Item<E> {
        public Item(E e) {
            this.item = e;
        }

        public E item;
        public Item next;
    }

    public Bucket(int size) {
        this.head = null;
        next = null;
        this.size = 0;
        max = size;
    }

    public E getAt(int index) {
        return (E) _get(index).item;
    }

    /**
     * Insert
     * - Insert element into list
     * - If the Bucket is full, make new bucket
     * Overflows are returned to be pushed to next
     *
     * @param index
     * @param item
     */
    public void insert(int index, E item) {
        Item curr = this.head;
        Item newitem = new Item(item);
        int i = index;

        if (this.head == null) {
            this.head = newitem;
            this.tail = newitem;
        }

        if (index > this.size + 1) {
            String err = "Index " + index + " does not exist. Size of array: " + this.size;
            throw new IndexOutOfBoundsException(err);
        }

        if(index == 0) {
            newitem.next = curr;
            this.head = newitem;
        }
        else if (index == this.size){
            this.tail.next = newitem;
            this.tail = newitem;
        }
        else {
            curr = _get(index);
            curr.next = newitem;
            newitem.next = curr.next.next;
        }
        this.size++;
        checkBucketStatus();

    }

    public void push(E item) {
        insert(this.size, item);
    }

    public E remove(int i) {
        return (E) _remove(i);
    }

    public boolean isEmpty() {
        return (this.size == 0) ? true : false;
    }

    private void checkBucketStatus(){
        //If overflow, remove the last element
        if (this.size > max) {
            Item extra = _remove(this.max - 1);
            if (this.next == null) this.next = new Bucket(max);
            this.next.insert(0, (E) extra.item);
        }
    }

    private Item _get(int index){
        Item curr = this.head;
        while (index > 0) {
            curr = curr.next;
            index--;
        }

        return curr;
    }

    private Item _remove(int i){
        Item curr = this.head;
        Item remove;
        if(i > this.size - 1){
            return null;
        }

        while (i > 0) {
            curr = curr.next;
            i--;
        }

        remove = curr.next;
        curr.next = curr.next.next;
        this.size--;
        checkBucketStatus();
        return curr;
    }

}
