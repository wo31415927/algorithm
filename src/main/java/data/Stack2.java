package data;

import java.util.Iterator;
import java.util.NoSuchElementException;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * zeyu
 * 2017/9/21
 */
@Data
public class Stack2<E> implements Iterable<E> {
    protected Node first;
    protected Node last;
    protected int cnt;

    public void push(E e) {
        cnt++;
        if (null == first) {
            first = last = new Node(e);
            return;
        }
        Node oldFirst = first;
        first = new Node(e);
        first.setNext(oldFirst);
        oldFirst.setPrev(first);
    }

    public E pop() {
        if (null == first) {
            throw new NoSuchElementException();
        }
        Node n = first;
        if (null == first.getNext()) {
            first = null;
            last = null;
        } else {
            first = first.getNext();
            first.setPrev(null);
            n.setNext(null);
        }
        cnt--;
        return n.getElemnet();
    }

    public int size() {
        return cnt;
    }

    @Override
    public Iterator<E> iterator() {
        return new ReverseIterator();
    }

    @AllArgsConstructor
    @Getter
    @Setter
    private class Node {
        protected E elemnet;
        protected Node prev;
        protected Node next;

        public Node(E elemnet) {
            this.elemnet = elemnet;
        }
    }

    private class ReverseIterator implements Iterator<E> {
        protected Node curNode = new Node(null, last, null);

        @Override
        public boolean hasNext() {
            return null != curNode.getPrev();
        }

        @Override
        public E next() {
            curNode = curNode.getPrev();
            return curNode.getElemnet();
        }
    }
}
