package book.base;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import lombok.Getter;
import lombok.Setter;

/**
 * 本算法的效率介于quick-union和quick-union加权之间
 * zeyu
 * 2017/9/22
 */
@Getter
@Setter
public class UF implements IUnion {
    protected int cnt;
    protected List<Node> allNodes = new LinkedList<>();

    public UF(int N) {
        for (int i = 0; i < N; i++) {
            allNodes.add(new Node(i));
        }
        cnt = N;
    }

    public boolean union(int p, int q) {
        if (p < 0 || p >= allNodes.size() || q < 0 || q >= allNodes.size()) {
            return false;
        }
        if (!connected(p, q)) {
            Node nodeP = allNodes.get(p);
            Node nodeQ = allNodes.get(q);
            nodeP.addRel(nodeQ);
            nodeQ.addRel(nodeP);
            if (allNodes.get(nodeP.getId()).getCnt() < allNodes.get(nodeQ.getId()).getCnt()) {
                nodeP.id(nodeQ.getId());
                allNodes.get(nodeP.getId()).setCnt(0);
                allNodes.get(nodeQ.getId()).setCnt(allNodes.get(nodeP.getId()).getCnt() + allNodes.get(nodeQ.getId()).getCnt());
            } else {
                nodeQ.id(nodeP.getId());
                allNodes.get(nodeQ.getId()).setCnt(0);
                allNodes.get(nodeP.getId()).setCnt(allNodes.get(nodeP.getId()).getCnt() + allNodes.get(nodeQ.getId()).getCnt());
            }
            cnt--;
            return true;
        }
        return false;
    }

    public int find(int p) {
        return allNodes.get(p).getId();
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public int count() {
        return cnt;
    }

    public void printById() {
        Multimap<Integer, Node> resultMap = ArrayListMultimap.create();
        for (Node n : allNodes) {
            resultMap.put(n.getId(), n);
        }
        for (Map.Entry<Integer, Collection<Node>> entry : resultMap.asMap().entrySet()) {
            String s = " ";
            for (Node n : entry.getValue()) {
                s += n.getIndex() + " ";
            }
            System.out.println(entry.getKey() + " -> [" + s + "]");
        }
    }

    @Getter
    @Setter
    private class Node {
        //序号,识别自己
        protected int index;
        //相关节点
        protected Set<Node> relNodes = new HashSet<>();
        //分量
        protected int id;
        //当前分量包含的节点总数
        protected int cnt;

        public Node(int index) {
            this.index = index;
            this.id = index;
            this.cnt = 1;
        }

        public Node addRel(Node n) {
            relNodes.add(n);
            return this;
        }

        public Node id(int id) {
            if (this.id != id) {
                this.id = id;
                for (Node n : relNodes) {
                    n.id(id);
                }
            }
            return this;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Node)) return false;
            Node node = (Node) o;
            return index == node.index;
        }

        @Override
        public int hashCode() {
            return index;
        }
    }
}
