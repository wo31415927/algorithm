package leetcode.linerTable;

import java.util.Arrays;

import pojo.My;
import pojo.Orgin;

/**
 * Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.

 Do not allocate extra space for another array, you must do this in place with constant memory.

 For example, Given input array A = [1,1,2],

 Your function should return length = 2, and A is now [1,2].
 * zeyu
 * 2017/9/20
 */
public class RemoveDupArray {
    @My
    public static Integer[] removeDup(Integer[] src) {
        if (src.length == 0) return new Integer[]{};
        int i = 0;
        int j = 1;
        for (; i < src.length && j < src.length; ) {
            for (; j < src.length; j++) {
                if (src[i] != src[j]) {
                    if (j > ++i) {
                        src[i] = src[j];
                    }
                    j++;
                    break;
                }
            }
        }
        return Arrays.copyOfRange(src, 0, i + 1);
    }

    @Orgin
    public static Integer[] removeDup1(Integer[] nums) {
        if (nums.length == 0) return new Integer[]{};
        int index = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[index - 1])
                nums[index++] = nums[i];
        }
        return Arrays.copyOfRange(nums, 0, index);
    }
}
