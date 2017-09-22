package data;

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
 * zeyu
 * 2017/9/22
 */
@Getter
@Setter
public class UF {
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
            nodeP.addRel(nodeP);
            nodeQ.addRel(nodeQ);
            if (nodeP.getId() < nodeQ.getId()) {
                nodeQ.id(nodeP.getId());
            }else{
                nodeP.id(nodeQ.getId());
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
        return allNodes.get(p).getId() == allNodes.get(q).getId();
    }

    public int count() {
        return cnt;
    }

    public void printById(){
        Multimap<Integer,Node> resultMap = ArrayListMultimap.create();
        for(Node n : allNodes){
            resultMap.put(n.getId(),n);
        }
        for(Map.Entry<Integer,Collection<Node>> entry : resultMap.asMap().entrySet()){
            String s = " ";
            for(Node n : entry.getValue()){
                s += n.getIndex() + " ";
            }
            System.out.println(entry.getKey() + " -> [" + s + "]");
        }
    }

    @Getter
    @Setter
    private class Node {
        protected int index;
        protected Set<Node> relNodes = new HashSet<>();
        protected int id;

        public Node(int index) {
            this.index = index;
            this.id = index;
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

    }
}
