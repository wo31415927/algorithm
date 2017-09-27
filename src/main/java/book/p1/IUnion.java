package book.p1;

/**
 * zeyu
 * 2017/9/27
 */
interface IUnion {
    boolean union(int p, int q);

    int find(int p);

    boolean connected(int p, int q);

    int count();
}
