package binaryTree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Tree {
    Node root;

    public boolean completeTree(){
        Queue<Node> queue = new LinkedList<>();
        ((LinkedList<Node>) queue).add(root);
        int i = 1;
        while (!queue.isEmpty()){
            Node u = queue.poll();
            u.index = i++;
            if (u.parent != null){
                if (u.parent.left == u){
                    if (u.index / 2 != u.parent.index || u.index % u.parent.index != 0){
                        return false;
                    }
                }else if (u.parent.right == u){
                    if (u.index / 2 != u.parent.index || (u.index-1) % u.parent.index != 0){
                        return false;
                    }
                }
            }
            if (u.left != null) {
                ((LinkedList<Node>) queue).add(u.left);
            }
            if (u.right != null) {
                ((LinkedList<Node>) queue).add(u.right);
            }
        }
        return true;
    }

    private class pair{
        int seq;
        Node node;
    }
}

class Node {
    int index;
    Node left;
    Node right;
    Node parent;

    public Node(int index) {
        this.index = index;
    }
}
