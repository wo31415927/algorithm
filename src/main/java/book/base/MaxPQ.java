package book.base;

import java.util.Arrays;

import lombok.Getter;

/** zeyu 2017/10/11 */
@Getter
public class MaxPQ<E extends Comparable<E>> implements IPriorityQueue<E> {
  //指向最后一个元素
  protected int N;
  protected E[] arr;

  public MaxPQ(int max) {
    //不能直接new E[xx]
    arr = (E[]) new Comparable[max + 1];
  }

  public MaxPQ(E[] arr1) {
      this(arr1,0,arr1.length-1);
  }

  public MaxPQ(E[] arr1, int lo, int hi) {
    if (null == arr1 || 0 == arr1.length || lo >= hi) {
      throw new IllegalArgumentException();
    }
      N = hi - lo + 1;
      //arr[0]不存储是为了保证  arr[i] parent = arr[i/2]
    this.arr = (E[]) new Comparable[N + 1];
    for (int i = 1; i < arr.length; i++) {
      this.arr[i] = arr1[lo + i - 1];
    }
    for (int i = arr.length / 2; i >= 1; i--) {
      sink(arr, i);
    }
  }

  public static void sort(Comparable[] arr, int lo, int hi) {
    if (null == arr || 0 == arr.length) {
      return;
    }
    //由于输入数组arr[0]不为null,所以还是需要额外的空间
    MaxPQ maxPQ = new MaxPQ(arr, lo, hi);
    for (int i = hi; i >= lo; i--) {
      arr[i] = maxPQ.delMax();
    }
  }

  public void swim(Comparable[] arr, int i) {
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

  public void sink(Comparable[] arr, int i) {
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

  public static boolean less(Comparable[] arr, int i, int j) {
    return arr[i].compareTo(arr[j]) < 0;
  }

  public static void exch(Comparable[] arr, int i, int j) {
    Comparable tmp = arr[i];
    arr[i] = arr[j];
    arr[j] = tmp;
  }

  @Override
  public boolean isEmpty() {
    return 0 == N;
  }

  @Override
  public int size() {
    return N;
  }

  @Override
  public void insert(E e) {
    if (N >= arr.length - 1) {
      arr = Arrays.copyOf(arr, arr.length * 2);
    }
    arr[++N] = e;
    swim(arr, N);
  }

  @Override
  public E max() {
    return size() > 0 ? arr[1] : null;
  }

  @Override
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
}
