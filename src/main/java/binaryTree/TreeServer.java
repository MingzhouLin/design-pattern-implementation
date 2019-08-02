package binaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class TreeServer {

    public Node nextNode(Node cur){
        if (cur == null){
            return null;
        }
        Node nextNode = null;
        if (cur.right != null){
            nextNode = cur.right;
            while (nextNode.left != null){
                nextNode = nextNode.left;
            }
            return nextNode;
        }else {
            nextNode = cur;
            while (nextNode.parent != null && nextNode.parent.left != nextNode){
                nextNode = nextNode.parent;
            }
            nextNode = nextNode.parent;
            return nextNode;
        }
    }

    public boolean subtree(Tree A, Tree B){
        Queue<Node> queue = new LinkedList<>();
        ((LinkedList<Node>) queue).add(A.root);
        while (!queue.isEmpty()){
            Node u = queue.poll();
            if (u.id == B.root.id){
                if (judgeSubTree(u, B.root)){
                    return true;
                }
            }
            ((LinkedList<Node>) queue).add(u.left);
            ((LinkedList<Node>) queue).add(u.right);
        }
        return false;
    }

    private boolean judgeSubTree(Node a, Node b){
        if (b == null){
            return true;
        }
        if (a == null){
            return false;
        }
        if (a.id == b.id){
            return judgeSubTree(a.left, b.left) && judgeSubTree(a.right, b.right);
        }else {
            return false;
        }
    }
}
