package symmetricalBinaryTree;

import binaryTree.Node;


public class SymmetricalBinaryTree {

    public static boolean ifSymmetricalBinaryTree(Node left, Node right){
        if(left==null && right==null)
            return true;
        if(left==null || right==null)
            return false;
        return ifSymmetricalBinaryTree(left.left,right.right) && ifSymmetricalBinaryTree(left.right,right.left);
    }
}
