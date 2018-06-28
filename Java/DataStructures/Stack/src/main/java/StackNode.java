public class StackNode<E> {

    private int id;
    private E data;
    private StackNode next;

    public StackNode(E e, int id) {
        this.id = id;
        this.data = e;
        this.next = null;
    }

    public void setNext(StackNode next){
        this.next = next;
    }

    public StackNode getNext(){
        return this.next;
    }

    public E getVal(){
        return data;
    }




}
