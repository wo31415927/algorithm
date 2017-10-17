package book.search;

/**
 * zeyu
 * 2017/10/17
 */
public class BinarySearch {
    public static int rankRecursion(int num, Integer[] arr){
        return rankRecursion(num,arr,0,arr.length-1);
    }
    /**
     * 递归的写法
     * @param num
     * @param arr
     * @param start
     * @param end
     * @return
     */
    public static int rankRecursion(int num, Integer[] arr, int start, int end){
        if(start > end) {
            //未找到相应元素时,返回小于num的数量,即待插入的位置
            return start;
        }
        int mi = start + (end-start)/2;
        if(arr[mi] > num){
            return rankRecursion(num,arr,start,mi-1);
        }else if(arr[mi] < num){
            return rankRecursion(num,arr,mi+1,end);
        }else{
            return mi;
        }
    }

    public static int rank(int num, Integer[] arr) {
        return rank(num,arr,0,arr.length-1);
    }
        /**
         * 非递归的写法
         * @param num
         * @param arr
         * @param start
         * @param end
         * @return
         */
    public static int rank(int num, Integer[] arr,int start,int end){
        while(true) {
            if (start > end) {
                //未找到相应元素时,返回小于num的数量,即待插入的位置
                return start;
            }
            int mi = start + (end - start) / 2;
            if (arr[mi] > num) {
                //由于二分查找递归的内部动作每次都是一段数据,所以只要在无限循环中复用临时变量即可
                //若是像快速排序这种需要分治大于partition值的两部分内容,则可以将分治的子对象放入stack并反复访问stack
                end = mi - 1;
            } else if (arr[mi] < num) {
                start = mi + 1;
            } else {
                return mi;
            }
        }
    }
}
