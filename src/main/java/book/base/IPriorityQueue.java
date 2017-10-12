package book.base;

/**
 * zeyu
 * 2017/10/12
 */
public interface IPriorityQueue<E> {
    public boolean isEmpty();

    public int size();

    public void insert(E e);

    public E max();

    public E delMax();
}
