public class Stack<E> {

    private StackNode<E> head;

    public Stack(){
    }

    public E pop(){
        if(isEmpty())
            return null;
        E ret = head.getVal();
        head = head.getNext();
        return ret;
    }

    public void push(E val){
        StackNode<E> temp = new StackNode<E>(val,1);
        if(head == null) {
            head = temp;
            return;
        }
        temp.setNext(head);
        head = temp;
    }

    private StackNode head(){
        return head;
    }

    public boolean isEmpty(){
        return (head == null)? true:false;
    }

    @Override
    public String toString(){
        String result = "";
        StackNode cur = head;
        while(cur != null){
            result += cur.getVal().toString() + ",";
            cur = cur.getNext();
        }

        return result.substring(0,result.length()-2);
    }
}
