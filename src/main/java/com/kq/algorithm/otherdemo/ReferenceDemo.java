package com.kq.algorithm.otherdemo;

import com.kq.algorithm.tree.binarysorttree.dto.Node;

/**
 * ReferenceDemo
 *
 * @author kq
 * @date 2021/2/19 22:46
 * @since 1.0.0
 */
public class ReferenceDemo {

    public static void main(String[] args) {
        Node node = new Node(1);
        System.out.println(node);
        node(node);
        System.out.println(node);
    }

    public static void node(Node node) {
        node = new Node(5);
    }

}
