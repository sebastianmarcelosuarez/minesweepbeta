package com.model;

import java.util.Random;

public class Box {

    Boolean mine;
    Boolean hidden;
    BoxStatus status;


    public Box (){
        super();
        hidden = true;
        status = BoxStatus.NONE;

        Random random = new Random();
        int result = random.nextInt(2);
        System.out.println(result);

        if (result == 0)  mine = Boolean.TRUE; else mine = Boolean.FALSE;

    }

    public Boolean getMine() {
        return mine;
    }

    public void setMine(Boolean mine) {
        this.mine = mine;
    }

    public Boolean getHidden() {
        return hidden;
    }

    public void setHidden(Boolean hidden) {
        this.hidden = hidden;
    }

    public BoxStatus getStatus() {
        return status;
    }

    public void setStatus(BoxStatus status) {
        this.status = status;
    }
}

