import java.util.EmptyStackException;

public class MinStack  {

    private class Item{
        private Integer data;
        private Integer min;
        private Item next;

        public Item(Integer data){
            this.data = data;
            this.min = data;
            this.next = null;
        }
    }

    private Item head;
    private int min = 0;

    public MinStack(){
        head = null;
    }

    public void push(Integer e){
        if(head == null) {
            head = new Item(e);
            min = e;
            return;
        }

        Item temp = new Item(e);
        temp.next = head;
        head = temp;

        if(temp.min > head.min)
            temp.min = head.min;
    }

    public int pop(){
        if(head == null)
            throw new EmptyStackException();

        Integer result = head.data;
        head = head.next;
        return result;
    }

    public int getMin(){
        return head.min;
    }

}
