package book.sort;

import book.base.MaxPQ;

/** zeyu 2017/10/12 */
public class HeapArraySort extends BaseSort {

  @Override
  protected void sort(Comparable[] arr, int start, int end) {
    MaxPQ.sort(arr, start, end);
  }
}
