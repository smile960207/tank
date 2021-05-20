/*
 * Copyright (c) 2011-2025 PiChen.
 */

package cn.edu.hdu.tankbattle.service;

import cn.edu.hdu.tankbattle.context.GameContext;
import cn.edu.hdu.tankbattle.dto.RealTimeGameData;
import cn.edu.hdu.tankbattle.enums.LevelEnum;
import cn.edu.hdu.tankbattle.resource.map.Map;
import cn.edu.hdu.tankbattle.resource.map.xmlparse.MapParser;
import cn.edu.hdu.tankbattle.view.menu.CustomMapMenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.*;


@Service
public class MenuActionService {
    @Autowired
    private GameEventService gameEventService;

    @Autowired
    private GameContext gameContext;

    /**
     * 加载自定义地图
     *
     * @param mapName 地图名
     */
    public void loadCustomMap(String mapName) {
        gameContext.getRealTimeGameData().setMap(new Map(MapParser.getMapFromXml(mapName)));
        gameContext.startGame();
    }

    /**
     * 暂停游戏
     */
    public void stop() {
        RealTimeGameData gameData = gameContext.getRealTimeGameData();
        gameEventService.pauseOrResume(gameData);
    }

    /**
     * 开始游戏
     */
    public void start() {
        RealTimeGameData gameData = gameContext.getRealTimeGameData();
        if (!gameData.isStart()) { // 还没开始
            gameContext.startGame();// 已经开始了
            //this.setVisible(true);
        } else if (!gameData.isStop() && gameData.getMyTankNum() != 0) {
            // 暂停
            gameEventService.pauseOrResume(gameData);
            JOptionPane.showMessageDialog(null, "游戏已经开始", "提示", JOptionPane.INFORMATION_MESSAGE);
            // 恢复游戏
            gameEventService.pauseOrResume(gameData);
        } else if (gameData.isStop()) {
            JOptionPane.showMessageDialog(null, "游戏已经开始", "提示", JOptionPane.INFORMATION_MESSAGE);
        } else if (!gameData.isStop() && (gameData.getMyTankNum() == 0)) {
            gameContext.startGame();
        }
    }

    public void exit() {
        RealTimeGameData gameData = gameContext.getRealTimeGameData();
        // 暂停游戏
        gameEventService.pauseOrResume(gameData);
        int select = JOptionPane.showConfirmDialog(null, "退出游戏吗？", "退出确认", JOptionPane.YES_NO_OPTION);
        if (select == JOptionPane.OK_OPTION) {
            // 退出游戏
            gameEventService.exitGame();
        } else {
            // 恢复游戏
            gameEventService.pauseOrResume(gameData);
        }
    }

    public void again() {
        RealTimeGameData gameData = gameContext.getRealTimeGameData();
        if (!gameData.isStop()) {
            gameEventService.pauseOrResume(gameData);
        }
        int select = JOptionPane.showConfirmDialog(null, "确认重来", "选择确认", JOptionPane.OK_CANCEL_OPTION);
        if (select == JOptionPane.OK_OPTION) {
            gameEventService.pauseOrResume(gameData);
            gameContext.startLevel(gameData.getLevel());
        } else {
            gameEventService.pauseOrResume(gameData);
        }

    }

    public void first() {
        selectLevel(LevelEnum.FIRST_LEVEL);
    }

    public void second() {
        selectLevel(LevelEnum.SECOND_LEVEL);
    }

    public void third() {
        selectLevel(LevelEnum.THIRD_LEVEL);
    }

    public void fourth() {
        selectLevel(LevelEnum.FOUR_LEVEL);
    }

    public void fifth() {
        selectLevel(LevelEnum.FIVE_LEVEL);
    }

    public void selectLevel(LevelEnum level) {
        RealTimeGameData gameData = gameContext.getRealTimeGameData();
        if (gameData.isStart()) {
            if (!gameData.isStop()) {// 暂停游戏
                gameEventService.pauseOrResume(gameData);
            }
            int select = JOptionPane.showConfirmDialog(null, "您选择的是第" + level + "关，点击确定开始游戏", "选择确认", JOptionPane.OK_CANCEL_OPTION);
            if (select == JOptionPane.OK_OPTION) {
                if (gameData.isStart()) {
                    // 恢复游戏
                    gameEventService.pauseOrResume(gameData);
                }
                gameContext.startLevel(level);
            } else {
                if (gameData.isStart()) {
                    // 恢复游戏
                    gameEventService.pauseOrResume(gameData);
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "请先点击游戏Game菜单下的开始游戏", "提示", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void help() {
        JOptionPane.showMessageDialog(null,
                "坦克移动:---方向键---\n坦克开炮:------X键------\n每关只要打掉敌人8辆坦克即可过关，\n第五关有5辆坦克同时在地图上",
                "游戏帮助", JOptionPane.INFORMATION_MESSAGE);
    }

    public void about() {
        JOptionPane.showMessageDialog(null, "JAVA坦克大战CP版1.0\n作者:hdu - ChenPi\n", "关于游戏", JOptionPane.INFORMATION_MESSAGE);
    }

    public void createMap() {
        RealTimeGameData gameData = gameContext.getRealTimeGameData();
        gameData.setMapMakingMode(Boolean.TRUE);
        gameData.getEnemies().forEach(t -> t.setLive(Boolean.FALSE));
        gameData.getMyTanks().forEach(t -> t.setLive(Boolean.FALSE));
        gameData.getMyTanks().clear();
        gameData.getEnemies().clear();
        gameData.setMap(new Map());
        gameData.setStart(Boolean.TRUE);
    }

    public void saveMap() {
        RealTimeGameData gameData = gameContext.getRealTimeGameData();
        String inputValue = JOptionPane.showInputDialog("请输入自定义地图名称");
        System.out.println(inputValue);

        MapParser.generateXmlFromMap(gameData.getMap(), inputValue);

        JMenuItem newMapMenu = new JMenuItem(inputValue);
        newMapMenu.setActionCommand(CustomMapMenu.CUSTOM_MAP_ACTION_COMMAND);
        newMapMenu.addActionListener(gameContext.getMenuActionEventListener());
        gameContext.getTankBattleMenuBar().getCustomMapMenu().add(newMapMenu);
    }
}
