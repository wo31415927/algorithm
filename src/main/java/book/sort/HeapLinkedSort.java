package book.sort;

import book.base.MaxLinkedPQ;

/** cctv 2017/10/12 */
public class HeapLinkedSort extends BaseSort {
  @Override
  protected void sort(Comparable[] arr, int start, int end) {
    MaxLinkedPQ.sort(arr, start, end);
  }
}
