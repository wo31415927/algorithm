package book.sort;

import com.google.common.truth.Truth;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Collection;

/**
 * zeyu
 * 2017/10/9
 */
@RunWith(Parameterized.class)
public class Quick3SideSortTest extends QuickSortTest {
    //取出索引和参数值放在测试结果中作为注释
    @Parameterized.Parameters(name = "{index}")
    public static Collection getData() {
        //multiple=1 制造大量重复的数
        initArrList(1000,1);
        /*initArrList(9);
        Integer[] testArr =
                new Integer[]{
                        115, 210, 383, 320, 457, 473, 542, 709, 823
                };
        intList.getFirst()[2] = testArr;
        intList.getFirst()[3] = Arrays.copyOfRange(testArr, 0, testArr.length);
        Arrays.sort(intList.getFirst()[3]);*/
        return intList;
    }

    @Before
    public void setUp() throws Exception {
        baseSort = new Quick3SideSort();
    }

    @Test
    public void testCalcMedian() throws Exception {
        Quick3SideSort sideSort = (Quick3SideSort)baseSort;
        Truth.assertThat(sideSort.calcMedian(new Integer[]{1,3,2},0,2)).isEqualTo(1);
        Truth.assertThat(sideSort.calcMedian(new Integer[]{1,3,2,4,7,3,4,5,6,7,8},0,10)).isEqualTo(3);
    }

    @Test
    public void testSort() throws Exception {
        super.testSort(true);
    }
}