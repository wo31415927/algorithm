package book.base;

import java.util.Iterator;

import lombok.Getter;
import lombok.Setter;

/**
 * zeyu
 * 2017/10/12
 */
public class MaxLinkedPQ<E extends Comparable<E>> implements IPriorityQueue<E>,Iterable {
    protected int N;
    protected Node head;
    protected Node tail;
//    protected Node tailParent;

    public MaxLinkedPQ(E[] arr) {
        for (E e : arr) {
            insert(e);
        }
    }

    @Override
    public boolean isEmpty() {
        return 0 == N;
    }

    @Override
    public int size() {
        return N;
    }

    /**
     * 获取当前node左侧最年轻的子孙
     */
    protected Node leftDescendant(Node node) {
        while (null != node.getLeft()) {
            node = node.getLeft();
        }
        return node;
    }

    /**
     * 获取当前node右侧最年轻的子孙
     */
    protected Node rightDescendant(Node node) {
        while (null != node.getRight()) {
            node = node.getRight();
        }
        return node;
    }

    /**
     * 获取当前node右边的兄弟,一般情况下,兄弟为同一层次右侧的节点,当node为最右侧的节点时,兄弟为head左侧最年轻的子孙
     */
    protected Node nextTailParent(Node node) {
        if (node.isHead()) {
            return node;
        }
        Node parent = node.getParent();
        if (node.isLeftNode()) {
            return parent;
        } else {
            while (!parent.isLeftNode()) {
                if (parent.isHead()) return leftDescendant(parent);
                parent = parent.getParent();
            }
            return leftDescendant(parent.getParent().getRight());
        }
    }

    /**
     * 获取当前node左边的兄弟,一般情况下,兄弟为同一层次左侧的节点,当node为最左侧的节点时,兄弟为head右侧最年轻的子孙
     */
    protected Node leftBrother(Node node) {
        if (node.isHead()) {
            return node;
        }
        Node parent = node.getParent();
        if (!node.isLeftNode()) {
            return parent.getLeft();
        } else {
            while (parent.isLeftNode()) {
                if (parent.isHead()) break;
                parent = parent.getParent();
            }
            return rightDescendant(parent.isHead() ? parent : parent.getParent().getLeft());
        }
    }

    @Override
    public void insert(E e) {
        N++;
        //TODO 是不是insert的时候再计算tailParent比较好?这样del时无需再去修改tailParent了
        if (null == head) {
            head = new Node(e);
            tail = head;
            return;
        }
        Node tailParent = nextTailParent(tail);
        Node newNode = new Node(e);
        if (null == tailParent.getLeft()) {
            tailParent.setLeft(newNode);
            newNode.setLeftNode(true);
        } else {
            tailParent.setRight(newNode);
        }
        newNode.setParent(tailParent);
        tail = newNode;
        swim(newNode);
    }

    @Override
    public E max() {
        return head.getElement();
    }

    @Override
    public E delMax() {
        E element = max();
        if (head != tail) {
            exch(tail, head);
            Node tmp = tail;
            if (tmp.isLeftNode()) {
                tmp.getParent().setLeft(null);
            } else {
                tmp.getParent().setRight(null);
            }
            tail = leftBrother(tmp);
            tmp.setParent(null);
            sink(head);
        } else {
            head.setParent(null);
            head = null;
            tail = null;
        }
        N--;
        return element;
    }

    protected void swim(Node node) {
        while (true) {
            if (node.isHead()) return;
            Node parent = node.getParent();
            if (less(parent, node)) {
                exch(node, parent);
            } else {
                break;
            }
        }
    }

    protected void sink(Node node) {
        Node l1 = node.getLeft();
        Node l2 = node.getRight();
        Node tmpNode;
        if (null == l1) {
            if (null == l2) {
                return;
            }
            tmpNode = l2;
        } else {
            if (null == l2) {
                tmpNode = l1;
            } else {
                tmpNode = less(l1, l2) ? l2 : l1;
            }
        }
        if (less(node, tmpNode)) {
            exch(tmpNode, node);
            sink(node);
        } else {
            return;
        }
    }

    protected boolean less(Node n1, Node n2) {
        return n1.getElement().compareTo(n2.getElement()) < 0;
    }

    protected void exch(Node node1, Node node2) {
        if (node1 == node2) {
            return;
        } else if (node1.getParent() == node2) {
            exchSonAndFather(node1, node2);
        } else if (node2.getParent() == node1) {
            exchSonAndFather(node2, node1);
        } else {
            exchOther(node1, node2);
        }
    }

    protected void exchOther(Node node1, Node node2) {
        Node p1 = node1.getParent();
        Node l1 = node1.getLeft();
        Node r1 = node1.getRight();
        boolean isLeftChild = node1.isLeftNode();
        node1.setParent(node1 == node2.getParent() ? node2 : node2.getParent());
        if (!node2.isHead()) {
            if (node2.isLeftNode()) {
                node2.getParent().setLeft(node1);
                node1.setLeftNode(true);
            } else {
                node2.getParent().setRight(node1);
                node1.setLeftNode(false);
            }
        }
        node1.setLeft(node2.getLeft());
        if (null != node2.getLeft()) {
            node2.getLeft().setParent(node1);
        }
        node1.setRight(node2.getRight());
        if (null != node2.getRight()) {
            node2.getRight().setParent(node1);
        }
        node2.setParent(p1);
        if (null != p1) {
            if (isLeftChild) {
                p1.setLeft(node2);
                node2.setLeftNode(true);
            } else {
                p1.setRight(node2);
                node2.setLeftNode(false);
            }
        } else {
            node2.setLeftNode(false);
        }
        node2.setLeft(l1);
        if (null != l1) {
            l1.setParent(node2);
        }
        node2.setRight(r1);
        if (null != r1) {
            r1.setParent(node2);
        }
        //修改head,tail,tailParent指针指向
        head = head == node1 ? node2 : (head == node2 ? node1 : head);
        tail = tail == node1 ? node2 : (tail == node2 ? node1 : tail);
    }

    protected void exchSonAndFather(Node child, Node parent) {
        if (child.getParent() != parent) {
            throw new IllegalArgumentException("交换的Node不是父子关系");
        }
        Node p1 = parent.getParent();
        Node l2 = child.getLeft();
        Node r2 = child.getRight();
        boolean isLeftChild = child.isLeftNode();
        child.setParent(p1);
        if (null != p1) {
            if (parent.isLeftNode()) {
                p1.setLeft(child);
                child.setLeftNode(true);
            } else {
                p1.setRight(child);
                child.setLeftNode(false);
            }
        } else {
            child.setLeftNode(false);
        }
        parent.setParent(child);
        if (isLeftChild) {
            Node r1 = parent.getRight();
            child.setRight(r1);
            if (null != r1) {
                r1.setParent(child);
            }
            child.setLeft(parent);
            parent.setLeftNode(true);
        } else {
            Node l1 = parent.getLeft();
            child.setLeft(l1);
            l1.setParent(child);
            child.setRight(parent);
            parent.setLeftNode(false);
        }
        parent.setLeft(l2);
        if (null != l2) {
            l2.setParent(parent);
        }
        parent.setRight(r2);
        if (null != r2) {
            r2.setParent(parent);
        }
        //修改head,tail,tailParent指针指向
        head = head == parent ? child : head;
        tail = tail == child ? parent : tail;
    }

    @Override
    public Iterator iterator() {
        //TODO 实现遍历
        return null;
    }

    @Getter
    @Setter
    class Node {
        protected E element;
        protected Node parent;
        protected Node left;
        protected Node right;
        //是否是其父节点的左子节点
        protected boolean isLeftNode = false;

        public Node(E e) {
            this.element = e;
        }

        public boolean isHead() {
            return null == parent;
        }
    }
}
