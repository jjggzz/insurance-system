package com.insurance.business.constant;

public enum RuleEnum {
    INSURE(0,"投保人"),
    BENEFIT(1,"受益人"),
    SELL(2,"销售员"),
    ADMIN(3,"管理员");

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

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
