package com.kq.algorithm.tree.mytree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kq
 * @date 2021-03-03 9:03
 * @since 2020-0630
 */
public class MyNode {

    private Long id;

    private List<MyNode> childrens;

    public MyNode(Long id){
        this.id = id;
    }

    public List<MyNode> getChildrens() {
        return childrens;
    }

    public void setChildrens(List<MyNode> childrens) {
        this.childrens = childrens;
    }

    public int getSize(){
        return childrens==null?0:childrens.size();
    }

    public void init(){

        if(childrens==null) {
            childrens = new ArrayList<>();
            for (int i = 0; i < 1000; i++) {
                MyNode node = new MyNode(IDUtil.getIncrementId());
                childrens.add(node);
            }
        }
    }

}
