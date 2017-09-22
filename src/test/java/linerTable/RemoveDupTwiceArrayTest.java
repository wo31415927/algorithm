package linerTable;

import junit.framework.TestCase;

import java.util.Arrays;

/**
 * zeyu
 * 2017/9/20
 */
public class RemoveDupTwiceArrayTest extends TestCase {
    public void testRemoveDup() throws Exception {
        int[] arr = new int[]{1,1,1,2,3,3,4,4,4,5};
        System.out.println(Arrays.toString(arr));
        System.out.println(RemoveDupTwiceArray.removeDup(arr));
        System.out.println(Arrays.toString(arr));
    }
}