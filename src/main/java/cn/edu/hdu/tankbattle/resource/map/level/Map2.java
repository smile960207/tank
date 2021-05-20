/*
 * Copyright (c) 2011-2025 PiChen.
 */

package cn.edu.hdu.tankbattle.resource.map.level;

import cn.edu.hdu.tankbattle.entity.Iron;
import cn.edu.hdu.tankbattle.resource.map.Map;

import java.util.Vector;


public class Map2 extends Map {
    public Map2() {
        Vector<Iron> irons = this.getIrons();
        for (int i = 0; i < 25; i++) {
            if (i % 2 == 0)
                continue;
            if (i == 11 || i == 13)
                continue;
            Iron iron = new Iron(20 * i + 60, 60);
            irons.add(iron);
        }
        for (int i = 0; i < 25; i++) {
            if (i == 11 || i == 12 || i == 13)
                continue;
            Iron iron = new Iron(20 * i + 60, 540);
            irons.add(iron);
        }
        for (int i = 0; i < 25; i++) {
            if (i % 2 == 0)
                continue;
            if (i == 11 || i == 13)
                continue;
            Iron iron = new Iron(60, 20 * i + 60);
            irons.add(iron);
        }
        for (int i = 0; i < 25; i++) {
            if (i % 2 == 0)
                continue;
            if (i == 11 || i == 13)
                continue;
            Iron iron = new Iron(540, 20 * i + 60);
            irons.add(iron);
        }
        Iron iron = new Iron(290, 290);
        irons.add(iron);
        iron = new Iron(310, 290);
        irons.add(iron);
        iron = new Iron(290, 310);
        irons.add(iron);
        iron = new Iron(310, 310);
        irons.add(iron);
    }
}
