package com.kq.algorithm.binarysorttree.dto;

/**
 * Node
 *
 * @author kq
 * @date 2021/2/19 20:55
 * @since 1.0.0
 */
public class Node {

    private int value;
    private Node left;
    private Node right;

    public Node(){

    }

    public Node(int value) {
        this(value,null,null);
    }

    public Node(int value, Node left, Node right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public String toString() {
        return "Node{" +
                "value=" + value +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}
