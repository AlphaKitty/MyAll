package com.zyl.common.java.算法.力扣;

import java.util.List;

public class FullTrees {

    public List<TreeNode> allPossibleFBT(int N) {
        // 初始下标
        int index = 0;
        // 最小的三个节点的树个数
        int minTrees = N / 2;
        // 一种情况的节点打印
        int[] nodes = new int[N];
        // 构建树
        buildTree(nodes, minTrees, index);
        return null;
    }

    private void buildTree(int[] nodes, int t, int index) {
        if (--t != 0)
            buildTree(nodes, t, index);
        System.out.println(t);
    }

    public static void main(String[] args) {
        FullTrees fullTrees = new FullTrees();
        List<TreeNode> treeNodes = fullTrees.allPossibleFBT(7);
        // for (TreeNode treeNode : treeNodes) {
        //     System.out.println(treeNode);
        // }
    }
}

class TreeNode {

}