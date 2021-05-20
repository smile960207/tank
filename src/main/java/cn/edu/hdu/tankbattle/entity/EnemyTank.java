/*
 * Copyright (c) 2011-2025 PiChen.
 */

package cn.edu.hdu.tankbattle.entity;

import cn.edu.hdu.tankbattle.enums.DirectionEnum;
import cn.edu.hdu.tankbattle.enums.TankTypeEnum;

import java.awt.*;
import java.util.Timer;


public class EnemyTank extends Tank {
    /**
     * 敌人坦克刚出现时从左到右排列的5个固定地方
     */
    private int location;
    /**
     * 我的坦克在敌人坦克的相对位置，正北方‘正南方’正西方‘正东方，-1为不知道
     */
    private DirectionEnum myTankLocation = DirectionEnum.INVALID;
    /**
     * 我的坦克方向
     */
    private DirectionEnum myTankDirect = DirectionEnum.NORTH;
    /**
     * 定时器
     */
    private Timer timer;
    /**
     * 是否要开火
     */
    private boolean isShot = false;

    /**
     * 敌人坦克构造方法
     *
     * @param x x
     * @param y y
     * @param direct direct
     */
    public EnemyTank(int x, int y, DirectionEnum direct) {
        super(x, y, direct);
        this.setSpeed(4);
        this.setTankType(TankTypeEnum.ENEMY);
        this.setDirect(DirectionEnum.NORTH);
        this.setColor(Color.red);
        this.setBlood(10);
        this.setSpeedVector(0); // 设为0表示没有保存坦克的速度，按下暂停时速度就不会是0
        timer = new Timer();

    }


    public int getLocation() {
        return location;
    }

    public void setLocation(int location) {
        this.location = location;
    }

    public Timer getTimer() {
        return timer;
    }

    public void setTimer(Timer timer) {
        this.timer = timer;
    }


    public boolean isShot() {
        return isShot;
    }

    public void setShot(boolean isShot) {
        this.isShot = isShot;
    }

    public DirectionEnum getMyTankLocation() {
        return myTankLocation;
    }

    public void setMyTankLocation(DirectionEnum myTankLocation) {
        this.myTankLocation = myTankLocation;
    }

    public DirectionEnum getMyTankDirect() {
        return myTankDirect;
    }

    public void setMyTankDirect(DirectionEnum myTankDirect) {
        this.myTankDirect = myTankDirect;
    }
}

