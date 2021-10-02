package com.sparta.model;

public class BinaryTreeSort extends SuperSort{
    private static class TreeNode {

        //------------------------------------------------------------------------
        //Nodes and Value
        //------------------------------------------------------------------------
        private int value;
        private TreeNode leftNode;
        private TreeNode rightNode;


        public TreeNode(int value) {
            this.value = value;
            this.leftNode = null;
            this.rightNode = null;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public TreeNode getLeftNode() {
            return leftNode;
        }

        public void setLeftNode(TreeNode leftNode) {
            this.leftNode = leftNode;
        }

        public TreeNode getRightNode() {
            return rightNode;
        }


        public void setRightNode(TreeNode rightNode) {
            this.rightNode = rightNode;
        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "value=" + value +
                    ", leftNode=" + leftNode +
                    ", rightNode=" + rightNode +
                    '}';
        }
    }

    // ------------------------------------------------------
    // using the number of nodes that are within the tree
    // ------------------------------------------------------
    public int[] sort(int[] myArr){
        setStartTime();
        int arrLen = myArr.length;
        TreeNode root = null;
        for(int i = 0; i<arrLen;i++)
            root = add(root,myArr[i]);

        String stringTemp = inOrderTreeTraversal(root);
        String[] stringTempArr = stringTemp.split(" ");
        int[] finArr = new int[arrLen];
        for(int i =0; i<arrLen;i++){
          finArr[i] = Integer.parseInt(stringTempArr[i]);
        }
        setEndTime();
        return finArr;
    }

    public static String inOrderTreeTraversal(TreeNode root){
        if(root ==null){
            return "";
        }
        String leftNode = String.valueOf(inOrderTreeTraversal(root.leftNode));
        String currentNode = String.valueOf(root.value +" ");
        String rightNode = String.valueOf(inOrderTreeTraversal(root.rightNode));
        return leftNode +currentNode+rightNode;

    }

    public static TreeNode add(TreeNode root, int value) {

        if(root == null){
            TreeNode n = new TreeNode(value);
            return n;
        }

        if(value < root.getValue()){
            root.leftNode = add(root.leftNode,value);
        }
        if(value >= root.getValue()){
            root.rightNode = add(root.rightNode,value);// this might not be normal for a binary tree, but what's important here is that we are using the binary tree method to SORT A LIST OF INTS which is what mine does, its also what the visualiser does
        }
        return root;
    }

    //    public static boolean isPerfectBinaryTree(int count) { // this completely breaks it dont both using perfect binary tree, we just want it to order
//        count++;
//        while(count%2 ==0)
//            count = count/2;
//        if(count==1)
//            return true;
//        else return false;
//    }


    @Override
    public String toString() {
        return "BinaryTreeSort";
    }
}

