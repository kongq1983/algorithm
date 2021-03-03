package com.kq.algorithm.tree.mytree;


import java.util.ArrayList;
import java.util.List;

/**
 * @author kq
 * @date 2021-03-03 9:04
 * @since 2020-0630
 */
public class MyTree {

    List<MyNode> childrens;

    public List<MyNode> getChildrens() {
        return childrens;
    }

    public void setChildrens(List<MyNode> childrens) {
        this.childrens = childrens;
    }

    public static void main(String[] args) {
        MyTree myTree = new MyTree();

        List<MyNode> childrens = new ArrayList<>();
        for(int i=0;i<1000;i++) {
            MyNode node = new MyNode(IDUtil.getIncrementId()); //1000  10的3次方
            childrens.add(node);
        }

        myTree.setChildrens(childrens);
        // 1000*1000
        for(MyNode myNode : childrens) {
            myNode.init(); //1000000 //1百万  10的6次方

            for(MyNode secondNode : myNode.getChildrens()) {
                secondNode.init(); //1000000000  10亿  10的9次方
            }

        }


        System.out.println("total="+IDUtil.getCurrentId());
    }

}
