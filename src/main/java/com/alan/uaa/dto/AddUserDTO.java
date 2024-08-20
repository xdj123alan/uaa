package com.alan.uaa.dto;

import lombok.Data;

import java.util.List;

@Data
public class AddUserDTO {

    private Long userId;

    private List<String> endpoint;
}
