public class UnrolledList<E> {

    private Bucket head;
    private int BUCKET_SIZE = 1;

    public UnrolledList(int bucketSize) {
        BUCKET_SIZE = bucketSize;
        head = new Bucket<E>(bucketSize);
    }

    public boolean isEmpty() {
        if (head.isEmpty())
            return true;
        return false;
    }

    public void push(E e) {


        return;
    }


    public E pop() {
        return null;
    }

    public E get(int i) {
        return null;
    }

    public void insert(int i, E e) {
        return;
    }

    public E remove(int i) {
        return null;
    }

    public int length() {
//        int size = (list.size() - 1) * BUCKET_SIZE;
        return 0;
    }

}
