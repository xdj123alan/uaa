package com.alan.uaa.dto;

import lombok.Data;

@Data
public class UserRoleDTO {

    private static final long serialVersionUID  = 1L;

    private Long userId;

    private String accountName;

    private String role;
}
