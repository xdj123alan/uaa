package com.alan.uaa.demos.web;

import com.alan.uaa.dto.AddUserDTO;
import com.alan.uaa.dto.ResultDTO;
import com.alan.uaa.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
public class UserController {

    @Resource
    private UserService userService;

    @PostMapping("/admin/addUser")
    public ResultDTO adminAddUser(@RequestBody AddUserDTO addUserDTO) throws Exception {
        return userService.adminAddUser(addUserDTO);
    }

    @GetMapping("/user/{resource}")
    public ResultDTO judgeUserResource(@PathVariable("resource") String resource) {
        return userService.userResource(resource)? ResultDTO.success("success"):ResultDTO.success("failure");
    }
}
