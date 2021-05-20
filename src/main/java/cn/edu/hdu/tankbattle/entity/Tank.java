/*
 * Copyright (c) 2011-2025 PiChen.
 */

package cn.edu.hdu.tankbattle.entity;

import cn.edu.hdu.tankbattle.constant.GameConstants;
import cn.edu.hdu.tankbattle.enums.DirectionEnum;
import cn.edu.hdu.tankbattle.enums.StuffTypeEnum;
import cn.edu.hdu.tankbattle.enums.TankTypeEnum;

import java.awt.*;
import java.util.Vector;


public class Tank extends Stuff {
    /**
     * 坦克的颜色
     */
    private Color color = Color.green;
    /**
     * 坦克的移动速度
     */
    private int speed = 4; // 坦克移动速度
    /**
     * 挡住坦克前面的东西
     */
    private StuffTypeEnum frontStuff = StuffTypeEnum.INVALID;
    /**
     * 坦克的子弹容量
     */
    private Vector<Bullet> bullets;
    /**
     * 坦克是否重叠属性,前面的障碍物不可过去
     */
    private boolean isOverlapAndCanNotShot = false;
    /**
     * 坦克是否重叠，前面的障碍物可以过去，用子弹可以打掉
     */
    private boolean isOverlapCanShot = false;
    /**
     * 游戏暂停时存储TANK移动速度
     */
    private int speedVector;

    private Boolean isActivate = Boolean.FALSE;
    /**
     * 东西第二个类型属性
     */
    private TankTypeEnum tankType;

    /**
     * 坦克的构造方法
     *
     * @param x      坦克的x坐标
     * @param y      坦克的y坐标
     * @param direct 坦克的方向
     */
    public Tank(int x, int y, DirectionEnum direct) {
        super(x, y);
        this.setDirect(direct);
        this.bullets = new Vector<>();
        this.setType(StuffTypeEnum.TANK);
        this.setWidth(40);
        this.setHeight(40);
    }


    /**
     * 坦克往北走
     */
    public void goNorth() {
        this.setDirect(DirectionEnum.NORTH);
        if (this.getY() > 20) {
            this.setY(this.getY() - this.speed);
        } else {
            this.setFrontStuff(StuffTypeEnum.IRON);
        }
    }

    /**
     * 坦克往南走
     */
    public void goSouth() {
        this.setDirect(DirectionEnum.SOUTH);
        if (this.getY() < GameConstants.GAME_PANEL_HEIGHT - 20) {
            this.setY(this.getY() + this.speed);
        } else {
            this.setFrontStuff(StuffTypeEnum.IRON); // 碰到边界就相当于碰到铁块
        }
    }

    /**
     * 坦克往西走
     */
    public void goWest() {
        this.setDirect(DirectionEnum.WEST);
        if (this.getX() > 20 && this.getY() <= GameConstants.GAME_PANEL_HEIGHT - 20) {
            this.setX(this.getX() - this.speed);
        } else {
            this.setFrontStuff(StuffTypeEnum.IRON);
        }
    }

    /**
     * 坦克往东走
     */
    public void goEast() {
        this.setDirect(DirectionEnum.EAST);
        if (this.getX() < GameConstants.GAME_PANEL_WIDTH - 20
                && this.getY() <= GameConstants.GAME_PANEL_HEIGHT - 20) {
            this.setX(this.getX() + this.speed);
        } else {
            this.setFrontStuff(StuffTypeEnum.IRON);
        }
    }

    /**
     * 坦克往东走
     */
    public void moveEast() {
        if (this.getX() < GameConstants.GAME_PANEL_WIDTH - 20
                && this.getY() <= GameConstants.GAME_PANEL_HEIGHT - 20) {
            this.setX(this.getX() + this.speed);
        } else {
            this.setFrontStuff(StuffTypeEnum.IRON);
        }
    }

    /**
     * 坦克往指定的方向走
     *
     * @param where 方向
     */

    public void go(DirectionEnum where) {
        switch (where) {
            case NORTH:
                this.goNorth();
                break;
            case SOUTH:
                this.goSouth();
                break;
            case WEST:
                this.goWest();
                break;
            case EAST:
                this.goEast();
                break;
            default:
                break;
        }
    }

    /**
     * 坦克往后走
     */
    public void goBack() {
        switch (this.getDirect()) {
            case NORTH:
                this.goSouth();
                break;
            case SOUTH:
                this.goNorth();
                break;
            case WEST:
                this.goEast();
                break;
            case EAST:
                this.goWest();
                break;
            default:
                break;
        }
    }


    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Vector<Bullet> getBullets() {
        return bullets;
    }

    public void setBullets(Vector<Bullet> bullets) {
        this.bullets = bullets;
    }

    public void setSpeedVector(int speedVector) {
        this.speedVector = speedVector;
    }

    public int getSpeedVector() {
        return speedVector;
    }

    public boolean isOverlapAndCanNotShot() {
        return isOverlapAndCanNotShot;
    }

    public void setOverlapAndCanNotShot(boolean isOverlapNo) {
        this.isOverlapAndCanNotShot = isOverlapNo;
    }

    public boolean isOverlapCanShot() {
        return isOverlapCanShot;
    }

    public void setOverlapCanShot(boolean isOverlapYes) {
        this.isOverlapCanShot = isOverlapYes;
    }

    public StuffTypeEnum getFrontStuff() {
        return frontStuff;
    }

    public void setFrontStuff(StuffTypeEnum frontStuff) {
        this.frontStuff = frontStuff;
    }

    public Boolean activate() {
        return isActivate;
    }

    public void setActivate(Boolean activate) {
        isActivate = activate;
    }

    public TankTypeEnum getTankType() {
        return tankType;
    }

    public void setTankType(TankTypeEnum tankType) {
        this.tankType = tankType;
    }
}
