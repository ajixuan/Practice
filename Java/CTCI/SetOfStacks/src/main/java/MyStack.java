public class MyStack<E> {
    public MyStack next;
    public Item head;
    public int size;

    private class Item<E> {
        public Item next;
        public E data;

        public Item(E e) {
            data = e;
            next = null;
        }
    }

    public MyStack() {
        next = null;
        head = null;
        size = 0;
    }

    public void push(E e) {
        if (head == null) {
            head = new Item(e);
            size++;
            return;
        }

        Item temp = new Item(e);
        temp.next = head;
        head = temp;
        size++;
    }

    public E pop(){
        E data = (E) head.data;
        head = head.next;
        size--;
        return data;
    }
}
