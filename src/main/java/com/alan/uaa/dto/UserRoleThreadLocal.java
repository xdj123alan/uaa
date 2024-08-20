package com.alan.uaa.dto;


public class UserRoleThreadLocal {


    private static final ThreadLocal<UserRoleDTO> contextHolder = new ThreadLocal<>();

    public static void setContextHolder(UserRoleDTO userRoleDTO){
        contextHolder.set(userRoleDTO);
    }

    public static UserRoleDTO getContextHolder(){
        return contextHolder.get();
    }

    public static void removeContextHolder(){
        contextHolder.remove();
    }

}
