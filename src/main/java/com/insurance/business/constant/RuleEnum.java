package com.insurance.business.constant;

public enum RuleEnum {
    SELL(1,"销售员"),
    ADMIN(2,"管理员");

    RuleEnum(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

    public static String getNameByCode(Integer code) {
        for (RuleEnum value : RuleEnum.values()) {
            if (value.code.intValue() == code.intValue()) {
                return value.name;
            }
        }
        return null;
    }

    private Integer code;
    private String name;




}
