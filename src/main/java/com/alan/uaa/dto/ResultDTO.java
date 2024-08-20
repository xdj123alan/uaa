package com.alan.uaa.dto;

import com.alan.uaa.enums.ResultTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class ResultDTO implements Serializable {

    private static final long serialVersionUID  = 1L;

    private Integer status;

    private String result;

    private String errorMsg;

    public static ResultDTO success(String data){
        return new ResultDTO(ResultTypeEnum.SUCCESS.getStatus(), data, null);
    }

    public static ResultDTO error(String errorMsg){
        return new ResultDTO(ResultTypeEnum.ERROR.getStatus(), null, errorMsg);
    }

    public static ResultDTO noAuth(){
        return new ResultDTO(ResultTypeEnum.NOAUTH.getStatus(), null, ResultTypeEnum.NOAUTH.getErrorMsg());
    }

    public static ResultDTO systemError(){
        return new ResultDTO(ResultTypeEnum.SYSTEM_ERROR.getStatus(), null, ResultTypeEnum.SYSTEM_ERROR.getErrorMsg());
    }
}
