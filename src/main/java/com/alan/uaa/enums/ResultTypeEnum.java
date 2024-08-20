package com.alan.uaa.enums;

import lombok.Data;

public enum ResultTypeEnum {

    SUCCESS(200, "success", ""),
    ERROR(400, "fail", ""),
    NOAUTH(401, "fail", "no access"),
    SYSTEM_ERROR(500, "fail", "system error"),
    ;

    private Integer status;

    private String result;

    private String errorMsg;

    ResultTypeEnum(int status, String result, String errorMsg) {
        this.status = status;
        this.result = result;
        this.errorMsg = errorMsg;
    }

    public Integer getStatus() {
        return status;
    }

    public String getResult() {
        return result;
    }

    public String getErrorMsg() {
        return errorMsg;
    }
}
