package com.alan.uaa.service.impl;

import com.alan.uaa.dto.AddUserDTO;
import com.alan.uaa.dto.ResultDTO;
import com.alan.uaa.dto.UserRoleThreadLocal;
import com.alan.uaa.enums.RoleTypeEnum;
import com.alan.uaa.repositotry.UserRepository;
import com.alan.uaa.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserRepository repository;

    @Override
    public ResultDTO adminAddUser(AddUserDTO addUserDTO) throws Exception {
        if(Objects.isNull(UserRoleThreadLocal.getContextHolder()) ||
                !RoleTypeEnum.ADMIN.name().equalsIgnoreCase(UserRoleThreadLocal.getContextHolder().getRole())){
            return ResultDTO.noAuth();
        }
        if(Objects.isNull(addUserDTO.getUserId()) || CollectionUtils.isEmpty(addUserDTO.getEndpoint())){
            throw new Exception("lack of params");
        }
        if(repository.upsetUserResource(addUserDTO)){
            return ResultDTO.success("OK");
        } else {
            return ResultDTO.systemError();
        }
    }

    @Override
    public Boolean userResource(String resource) {
        List<String> resources = repository.getResourceByUserId(UserRoleThreadLocal.getContextHolder().getUserId());
        return !CollectionUtils.isEmpty(resources) && resources.contains(resource);
    }

}
