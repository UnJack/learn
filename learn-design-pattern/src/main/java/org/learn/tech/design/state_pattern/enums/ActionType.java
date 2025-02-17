package org.learn.tech.design.state_pattern.enums;

import lombok.Getter;

/**
 * 行为枚举
 */
@Getter
public enum ActionType {

    START(1, "开始"),
    STOP(2, "暂停"),
    ACHIEVE(3, "完成"),
    EXPIRE(4, "过期");
    private final int code;
    private final String message;

    ActionType(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
