package binaryTree;

import symmetricalBinaryTree.SymmetricalBinaryTree;

public class Demo {
    public static void main(String[] args) {
        Demo demo = new Demo();
        Tree tree = demo.buildTree();
        Tree tree1 = new Tree();
        Node node = new Node(1);
        tree1.root = node;
        if (tree.root == null){
            System.out.println(true);
        }else {
            System.out.println(SymmetricalBinaryTree.ifSymmetricalBinaryTree(tree1.root.left, tree1.root.right));
        }
    }

    /*
        1
       2 3
     4 5 6 7
    8 9 10
     */

    public Tree buildTree(){
        Tree tree = new Tree();
        Node node = new Node(1);
        tree.root = node;
        Node node1 = new Node(2);
        tree.root.left = node1;
        node1.parent = tree.root;
        Node node2 = new Node(3);
        tree.root.right = node2;
        node2.parent = tree.root;
        node = new Node(4);
        node1.left = node;
        node.parent = node1;
        node = new Node(5);
        node1.right = node;
        node.parent = node1;
        node = new Node(6);
        node2.left = node;
        node.parent = node2;
        node = new Node(7);
        node2.right = node;
        node.parent = node2;
        node = new Node(8);
        node1.left.left= node;
        node.parent = node1.left;
//        node = new Node(9);
//        node1.left.right = node;
//        node.parent = node1.left;
        node = new Node(10);
        node2.right.right = node;
        node.parent = node2.right;
        return tree;
    }

    public void preOrderPrint(Node cur){
        if (cur != null) {
            System.out.print(" " + cur.id);
            preOrderPrint(cur.left);
            preOrderPrint(cur.right);
        }
    }
}
