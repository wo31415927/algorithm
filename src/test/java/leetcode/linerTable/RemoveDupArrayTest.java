package leetcode.linerTable;

import com.google.common.truth.Truth;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

/**
 * zeyu
 * 2017/9/20
 */
@RunWith(Parameterized.class)
public class RemoveDupArrayTest{
    @Parameterized.Parameter(0)
    public /* NOT private */ Integer[] arr;
    @Parameterized.Parameter(1)
    public /* NOT private */ Integer[] expected;

    //取出索引和参数值放在测试结果中作为注释
    @Parameterized.Parameters(name = "{index}")
    public static Collection getData() {
        //每条记录包含声明了@Parameterized.Parameter(0)顺序的参数
        Integer intArray[][][]={{{},{}},{{1,1,1,1},{1}},{{1,2,3,4},{1,2,3,4}},{{1,1,2,3,3,4,5,5},{1,2,3,4,5}},{{1,2,2,3},{1,2,3}},{{3,2,2,1},{3,2,
                1}}};
        return Arrays.asList(intArray);
    }

    @Test
    public void testRemoveDup() throws Exception {
        Integer[] resultArr = RemoveDupArray.removeDup(arr);
        Truth.assertThat(resultArr).isEqualTo(expected);
        System.out.println(Arrays.toString(arr) + " -> " + Arrays.toString(resultArr));
    }
}