package book.base;

/**
 * zeyu
 * 2017/10/12
 */
public interface IPriorityQueue<E> {
    boolean isEmpty();

    int size();

    void insert(E e);

    E max();

    E delMax();
}
