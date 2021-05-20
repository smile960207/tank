/*
 * Copyright (c) 2011-2025 PiChen.
 */

package cn.edu.hdu.tankbattle.view.menu;

import javax.swing.*;
import java.awt.event.ActionListener;


public class HelpMenu extends JMenu {
    public HelpMenu(ActionListener listener) {
        super("游戏帮助");
        JMenuItem help = new JMenuItem("游戏帮助");
        JMenuItem about = new JMenuItem("关于游戏");

        help.setActionCommand("help");
        about.setActionCommand("about");

        help.addActionListener(listener);
        about.addActionListener(listener);

        this.add(help);
        this.add(about);
    }
}
