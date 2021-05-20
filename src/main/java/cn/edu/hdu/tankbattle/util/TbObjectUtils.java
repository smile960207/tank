/*
 * Copyright (c) 2011-2025 PiChen.
 */

package cn.edu.hdu.tankbattle.util;


public class TbObjectUtils extends org.springframework.util.ObjectUtils {
    public static boolean isNotEmpty(Object obj) {
        return !isEmpty(obj);
    }
}
