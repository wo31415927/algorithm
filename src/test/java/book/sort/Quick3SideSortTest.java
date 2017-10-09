package book.sort;

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
        initArrList(10);
        return intList;
    }

    @Before
    public void setUp() throws Exception {
        baseSort = new Quick3SideSort();
    }

    @Test
    public void testSort() throws Exception {
        super.testSort();
    }
}