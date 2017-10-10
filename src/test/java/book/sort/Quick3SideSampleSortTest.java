package book.sort;

import com.google.common.truth.Truth;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Collection;

/**
 * zeyu
 * 2017/10/10
 */
@RunWith(Parameterized.class)
public class Quick3SideSampleSortTest extends Quick3SideSortTest {
    //取出索引和参数值放在测试结果中作为注释
    @Parameterized.Parameters(name = "{index}")
    public static Collection getData() {
        //multiple=1 制造大量重复的数
//        initArrList(10000000,1);
        initArrList(10000000);
        return intList;
    }

    @Before
    public void setUp() throws Exception {
        baseSort = new Quick3SideSampleSort();
    }

    @Test
    public void testCalcMedian() throws Exception {
        Quick3SideSampleSort sideSort = (Quick3SideSampleSort) baseSort;
        Truth.assertThat(sideSort.calcMedian(new Integer[]{1, 3, 2}, 0, 2)).isEqualTo(1);
        Truth.assertThat(sideSort.calcMedian(new Integer[]{1, 3, 2, 4, 7, 3, 4, 5, 6, 7, 8}, 0, 10)).isEqualTo(4);
    }

    @Test
    public void testSort() throws Exception {
        super.testSort(false);
    }
}