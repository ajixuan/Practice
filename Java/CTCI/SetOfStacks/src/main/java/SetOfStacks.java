import java.util.EmptyStackException;

public class SetOfStacks<E> {
    private MyStack head;
    private int max;


    public SetOfStacks(int size){
        head = new MyStack();
        max = size;
    }

    public void push(E e){
        if(head.size == max){
            MyStack temp = new MyStack<E>();
            temp.next = head;
            head = temp;
        }

        head.push(e);
    }


    public E pop(){
        if(head.size == 0){
            if(head.next == null){
                throw new EmptyStackException();
            }
            head = head.next;
        }

       return (E) head.pop();
    }

}
