package book.base;

import java.util.Arrays;

import lombok.Getter;

/**
 * zeyu
 * 2017/10/11
 */
@Getter
public class MaxPQ<E extends Comparable<E>> {
    //指向最后一个元素
    protected int N;
    protected E[] arr;

    public MaxPQ(int max) {
        //不能直接new E[xx]
        arr = (E[]) new Comparable[max + 1];
    }

    public MaxPQ(E[] arr1) {
        if (null == arr1 || 0 == arr1.length) {
            throw new IllegalArgumentException();
        }
        this.arr = (E[]) new Comparable[arr1.length + 1];
        for (int i = 1; i < arr.length; i++) {
            this.arr[i] = arr1[i - 1];
        }
        N = arr1.length;
        for (int i = arr.length / 2; i >= 1; i--) {
            sink(arr, i);
        }
    }

    public boolean isEmpty() {
        return 0 == N;
    }

    public int size() {
        return N;
    }

    public void insert(E e) {
        if (N >= arr.length - 1) {
            arr = Arrays.copyOf(arr, arr.length * 2);
        }
        arr[++N] = e;
        swim(arr, N);
    }

    public E max() {
        return size() > 0 ? arr[1] : null;
    }

    public E delMax() {
        E e = max();
        arr[1] = arr[N];
        arr[N--] = null;
        sink(arr, 1);
        if (N + 1 <= arr.length / 4) {
            arr = Arrays.copyOf(arr, arr.length / 2);
        }
        return e;
    }

    protected void swim(Comparable[] arr, int i) {
        while (i > 1) {
            int parent = i / 2;
            if (less(arr, parent, i)) {
                exch(arr, i, parent);
                i = parent;
            } else {
                break;
            }
        }
    }

    protected void sink(Comparable[] arr, int i) {
        int j;
        while ((j = i * 2) <= N) {
            j = j == N ? N : (less(arr, j, ++j) ? j : j - 1);
            if (less(arr, i, j)) {
                exch(arr, i, j);
                i = j;
            } else {
                break;
            }
        }
    }

    protected boolean less(Comparable[] arr, int i, int j) {
        return arr[i].compareTo(arr[j]) < 0;
    }

    protected boolean greater(int i, int j) {
        return arr[i].compareTo(arr[j]) > 0;
    }

    protected void exch(Comparable[] arr, int i, int j) {
        Comparable tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
