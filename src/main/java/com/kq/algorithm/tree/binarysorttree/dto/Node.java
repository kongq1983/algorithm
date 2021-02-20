package com.kq.algorithm.tree.binarysorttree.dto;

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
    /** v2版本开始增加上去 */
    private Node parent;

    public Node(){

    }

    public Node(int value) {
        this(value,null,null);
    }

    /** since add v2 */
    public Node(Node parent, int value) {
        this.value = value;
        this.parent = parent;
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

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    /** toString,不要parent，否則死循環 */
    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}
