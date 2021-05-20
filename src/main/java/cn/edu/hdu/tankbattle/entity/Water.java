/*
 * Copyright (c) 2011-2025 PiChen.
 */

package cn.edu.hdu.tankbattle.entity;

import cn.edu.hdu.tankbattle.enums.StuffTypeEnum;


public class Water extends Stuff {
    /**
     * 构造方法
     *
     * @param x x坐标
     * @param y y坐标
     */

    public Water(int x, int y) {
        super(x, y);
        this.setType(StuffTypeEnum.WATER);
        this.setWidth(20);
        this.setHeight(20);
    }

}
