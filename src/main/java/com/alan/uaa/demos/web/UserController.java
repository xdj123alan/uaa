package com.alan.uaa.demos.web;

import com.alan.uaa.dto.AddUserDTO;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @PostMapping("/admin/addUser")
    public String adminAddUser(@RequestBody AddUserDTO addUserDTO) {
        return "Hello";
    }

    @GetMapping("/user/{resource}")
    public String judgeUserResource() {
        return "success";
    }
}
