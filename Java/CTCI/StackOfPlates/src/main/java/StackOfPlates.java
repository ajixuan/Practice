import java.util.ArrayList;
import java.util.List;

public class StackOfPlates<E>{

    private ArrayList<E> pile;
    private List<ArrayList<E>> stacks;
    private int threshold;

    public StackOfPlates(int threshold){
        this.threshold = threshold;
        pile = new ArrayList<>(threshold);
        stacks = new ArrayList<>();
        stacks.add(pile);
    }

    public void push(E e){
        if(pile.size() == threshold){
            pile  = new ArrayList<>();
            stacks.add(pile);
        }

        pile.add(e);
    }

    public E pop(){
        return pile.remove(pile.size() -  1);
    }

    public int pileSize(){
        return this.pile.size();
    }

    public int stackSize(){
        return this.stacks.size();
    }

    public E popAt(int index){
        ArrayList<E> pile = stacks.get(index);
        return null;
    }
}
