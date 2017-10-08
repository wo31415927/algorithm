package book.sort;

import lombok.Getter;
import lombok.Setter;

/** zeyu 2017/9/28 */
@Getter
@Setter
public class MergeSort extends BaseSort {
  protected Comparable[] aux = null;
  protected InsertSort insertSort = new InsertSort();
  public static final int MAX = 5;

  public void sort(Comparable[] a) {
    aux = new Comparable[a.length];
    sort(a, 0, a.length - 1);
  }

  protected void sort(Comparable[] a, int lo, int hi) {
    if (hi <= lo) return;
    //小于一定长度使用插入排序，经验表明可以提速10%-15%
    if (hi - lo < MAX) {
      insertSort.sort(a, lo, hi);
      return;
    }
    if (null == aux) {
      aux = new Comparable[a.length];
    }
    int mid = (hi - lo) / 2 + lo;
    sort(a, lo, mid);
    sort(a, mid + 1, hi);
    //对有序的数据避免再次merge
    if (a[mid].compareTo(a[mid + 1]) > 0) {
      merge(a, lo, mid, hi);
    }
  }

  /**
   * 复制整个aux
   *
   * @param a
   * @param lo
   * @param mid
   * @param hi
   */
  public void merge(Comparable[] a, int lo, int mid, int hi) {
    for (int k = lo; k <= hi; k++) {
      aux[k] = a[k];
    }
    int i = lo;
    int j = mid + 1;
    for (int k = lo; k <= hi; k++) {
      if (i > mid) {
        a[k] = aux[j++];
      } else if (j > hi) {
        a[k] = aux[i++];
      } else if (less(aux[j], aux[i])) {
        a[k] = aux[j++];
      } else {
        a[k] = aux[i++];
      }
    }
  }

  /**
   * 复制部分aux,排序结果不稳定,参见2.5.1.8
   *
   * @param a
   * @param lo
   * @param mid
   * @param hi
   */
  protected void merge1(Comparable[] a, int lo, int mid, int hi) {
    for (int k = lo; k <= mid; k++) {
      aux[k] = a[k];
    }
    int i = lo;
    int j = mid + 1;
    for (int k = lo; k <= hi; k++) {
      if (j > hi) {
        a[k] = aux[i++];
      } else if (less(a[j], aux[i])) {
        a[k] = aux[j++];
      } else {
        a[k] = aux[i++];
      }
    }
  }
}
