package binaryTree;

import java.util.*;

public class Tree {
    Node root;

    public int getDepth(){
        int depth = 0;
        return recursiveDepth(root, depth);
    }

    private int recursiveDepth(Node node, int depth){
        if (node == null){
            return depth;
        }else {
            return max(recursiveDepth(node.left, depth+1), recursiveDepth(node.right, depth+1));
        }
    }

    private int max(int par1, int par2){
        return par1 > par2 ? par1 : par2;
    }

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

    public void printAccrodingToLevel(){
        Queue<Node> queue = new LinkedList<>();
        HashMap<Integer, List<Node>> level = new HashMap<>();
        root.index = 1;
        queue.add(root);
        List<Node> first = new LinkedList<>();
        first.add(root);
        level.put(root.index, first);
        while (!queue.isEmpty()){
            Node cur = queue.poll();
            int nextLevel = cur.index +1;
            Node left = cur.left;
            Node right = cur.right;
            if (level.containsKey(nextLevel)){
                if (left != null){
                    ((LinkedList<Node>) queue).add(left);
                    left.index = nextLevel;
                    level.get(nextLevel).add(left);
                }
                if (right != null){
                    ((LinkedList<Node>) queue).add(right);
                    right.index = nextLevel;
                    level.get(nextLevel).add(right);
                }
            }else {
                List<Node> list = new LinkedList<>();
                if (left != null){
                    ((LinkedList<Node>) queue).add(left);
                    left.index = nextLevel;
                    list.add(left);
                }
                if (right != null){
                    ((LinkedList<Node>) queue).add(right);
                    right.index = nextLevel;
                    list.add(right);
                }
                level.put(nextLevel, list);
            }
        }
        for (Map.Entry<Integer, List<Node>> entry:
            level.entrySet()){
            for (Node node:
                 entry.getValue()) {
                System.out.print(node.id + " ");
            }
            System.out.println();
        }
    }

    private class pair{
        int seq;
        Node node;
    }
}


