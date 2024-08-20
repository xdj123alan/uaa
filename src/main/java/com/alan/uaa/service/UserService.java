package com.alan.uaa.service;

import com.alan.uaa.dto.AddUserDTO;
import com.alan.uaa.dto.ResultDTO;

public interface UserService {

    ResultDTO adminAddUser(AddUserDTO addUserDTO) throws Exception;

    Boolean userResource(String resource);
}
