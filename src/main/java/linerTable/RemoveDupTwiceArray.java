package linerTable;

import pojo.Orgin;

/**
 * zeyu
 * 2017/9/20
 */
public class RemoveDupTwiceArray {
    @Orgin
    public static int removeDup(int[] nums) {
        if (nums.length <= 2) return nums.length;
        int index = 2;
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] != nums[index - 2])
                nums[index++] = nums[i];
        }
        return index;
    }
}
