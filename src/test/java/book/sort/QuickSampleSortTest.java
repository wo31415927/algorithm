package book.sort;

import com.google.common.truth.Truth;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Collection;

/**
 * cctv
 * 2017/10/4
 */
@RunWith(Parameterized.class)
public class QuickSampleSortTest extends QuickSortTest{
  @Test
  public void testCalcMedian() throws Exception {
    QuickSampleSort sampleSort = (QuickSampleSort)baseSort;
    Truth.assertThat(sampleSort.calcMedian(new Integer[]{1,3,2},0,2)).isEqualTo(1);
    Truth.assertThat(sampleSort.calcMedian(new Integer[]{1,3,2,4,7},0,4)).isEqualTo(2);
  }

  //取出索引和参数值放在测试结果中作为注释
  @Parameterized.Parameters(name = "{index}")
  public static Collection getData() {
    return intList;
  }

  @Before
  public void setUp() throws Exception {
    baseSort = new QuickSampleSort(5,5);
  }

  @Test
  public void testSort() throws Exception {
    super.testSort();
  }
}