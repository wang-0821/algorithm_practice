package com.xiao.algorithm.tree;

import com.xiao.algorithm.TreeNode;

import java.util.Arrays;
import java.util.Iterator;

/**
 * leetcode 297
 * 二叉树序列化与反序列化
 *
 * @author lix wang
 */
public class SerializeAndDeserializeBinaryTree {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        String result = "[";
        result = toSerializeStringPreOrder(root, result);
        return result.substring(0, result.length() - 1) + "]";
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] parts = data.substring(1, data.length() - 1).split(",");
        Iterator<String> iterator = Arrays.asList(parts).iterator();
        return toDeserializeTreeNodePreOrder(iterator);
    }

    /**
     * 前序遍历：中、左、右。 root -> root.left -> root.left.left -> ...
     * 先访问根节点，再遍历左子树，再遍历右子树。
     */
    private String toSerializeStringPreOrder(TreeNode root, String result) {
        if (root == null) {
            result += "null,";
        } else {
            result = result + root.val + "," ;
            result = toSerializeStringPreOrder(root.left, result);
            result = toSerializeStringPreOrder(root.right, result);
        }
        return result;
    }

    private TreeNode toDeserializeTreeNodePreOrder(Iterator<String> iterator) {
        String val;
        if (!iterator.hasNext() || "null".equals((val = iterator.next()))) {
            return null;
        }
        TreeNode node = new TreeNode(Integer.valueOf(val));
        node.left = toDeserializeTreeNodePreOrder(iterator);
        node.right = toDeserializeTreeNodePreOrder(iterator);
        return node;
    }

    /**
     * 中序遍历，先中序遍历左子树，再访问根节点，最后遍历右子树
     */
    private String toSerializeStringInOrder(TreeNode root, String result) {
        if (root == null) {
            result += "null,";
        } else {
            result = toSerializeStringInOrder(root.left, result);
            result = result + root.val + ",";
            result = toSerializeStringInOrder(root, result);
        }
        return result;
    }

    /**
     * 后序遍历，先遍历左子树，再遍历右子树，最后遍历根节点
     */
    private String toSerializeStringPosOrder(TreeNode root, String result) {
        if (root == null) {
            result += "null,";
        } else {
            result = toSerializeStringPosOrder(root.left, result);
            result = toSerializeStringPosOrder(root.left, result);
            result = result + root.val + ",";
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        SerializeAndDeserializeBinaryTree obj = new SerializeAndDeserializeBinaryTree();
        String s = obj.serialize(root);
        System.out.println(s);
        TreeNode node = obj.deserialize(s);
        System.out.println(node);
    }
}
