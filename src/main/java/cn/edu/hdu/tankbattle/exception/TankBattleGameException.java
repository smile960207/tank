/*
 * Copyright (c) 2011-2025 PiChen.
 */

package cn.edu.hdu.tankbattle.exception;


public class TankBattleGameException extends RuntimeException {
    public TankBattleGameException() {
        super();
    }

    public TankBattleGameException(String message) {
        super(message);
    }

    public TankBattleGameException(Throwable cause) {
        super(cause);
    }

    public TankBattleGameException(String message, Throwable cause) {
        super(message, cause);
    }
}
