package book.sort;

import com.google.common.truth.Truth;

import org.junit.Before;

/** cctv 2017/10/1 */
public class MergeSort1Test extends MergeSortTest {
  @Override
  @Before
  public void setUp() throws Exception {
    baseSort = new MergeSort1(new Integer[arr.length]);
  }

  @Override
  public void testSort() throws Exception {
    //        Integer[] orgin = Arrays.copyOfRange(arr, 0, arr.length);
    MergeSort1 mergeSort1 = (MergeSort1) baseSort;
    mergeSort1.sort(arr, mergeSort1.getAux(), start[0], end[0]);
    Truth.assertThat(arr).isEqualTo(expected);
    //        System.out.println(Arrays.toString(orgin) + " -> " + Arrays.toString(arr));
  }
}
