/*
 * Copyright (c) 2011-2025 PiChen.
 */

package cn.edu.hdu.tankbattle.task;

import cn.edu.hdu.tankbattle.entity.EnemyTank;
import cn.edu.hdu.tankbattle.service.TankControlService;

import java.util.TimerTask;


public class EnemyTankAutoShotTask extends TimerTask {
    private EnemyTank enemyTank;
    private TankControlService tankControlService;

    public EnemyTankAutoShotTask(EnemyTank enemyTank, TankControlService tankControlService) {
        this.enemyTank = enemyTank;
        this.tankControlService = tankControlService;
    }

    @Override
    public void run() {
        if (enemyTank.getSpeedVector() == 0 && enemyTank.isShot() && enemyTank.activate()) {
            tankControlService.shot(enemyTank);
        }

    }

}
