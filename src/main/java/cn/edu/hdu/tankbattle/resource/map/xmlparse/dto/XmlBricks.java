/*
 * Copyright (c) 2011-2025 PiChen.
 */

package cn.edu.hdu.tankbattle.resource.map.xmlparse.dto;

import org.apache.commons.digester3.annotations.rules.ObjectCreate;
import org.apache.commons.digester3.annotations.rules.SetNext;

import java.util.Vector;


@ObjectCreate(pattern = "map/bricks")
public class XmlBricks {
    private Vector<XmlBrick> bricks = new Vector<>();

    @SetNext
    public void addBrick(XmlBrick brick) {
        this.bricks.add(brick);
    }

    public Vector<XmlBrick> getBricks() {
        return bricks;
    }

    public void setBricks(Vector<XmlBrick> bricks) {
        this.bricks = bricks;
    }
}
