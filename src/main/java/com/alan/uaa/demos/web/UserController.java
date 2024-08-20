package com.alan.uaa.demos.web;

import com.alan.uaa.dto.AddUserDTO;
import com.alan.uaa.dto.UserRoleThreadLocal;
import com.alan.uaa.enums.RoleTypeEnum;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
public class UserController {

    @PostMapping("/admin/addUser")
    public String adminAddUser(@RequestBody AddUserDTO addUserDTO) throws Exception {
        if(Objects.isNull(UserRoleThreadLocal.getContextHolder()) ||
                !RoleTypeEnum.ADMIN.name().equalsIgnoreCase(UserRoleThreadLocal.getContextHolder().getRole())){
            return "no access";
        }
        return "OK";
    }

    @GetMapping("/user/{resource}")
    public String judgeUserResource() {
        return "success";
    }
}
