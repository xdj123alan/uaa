package com.alan.uaa.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class AddUserDTO implements Serializable {

    private static final long serialVersionUID  = 1L;

    private Long userId;

    private List<String> endpoint;
}
