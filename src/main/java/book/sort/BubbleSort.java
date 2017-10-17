package book.sort;

/**
 * zeyu
 * 2017/10/17
 */
public class BubbleSort extends BaseSort {
    @Override
    protected void sort(Comparable[] a, int start, int end) {
        if(start >= end){
            return;
        }
        for(int i=end-1;i>=start;i--){
            for(int j=start;j<=i;j++){
                if(less(a[j+1],a[j])){
                    exch(a,j,j+1);
                }
            }
        }
    }
}
