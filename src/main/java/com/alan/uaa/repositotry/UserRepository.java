package com.alan.uaa.repositotry;


import com.alan.uaa.dto.AddUserDTO;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class UserRepository {

    private Map<Long, List<String>> cache = new ConcurrentHashMap<>();

    public boolean upsetUserResource(AddUserDTO addUserDTO){
        try{
            cache.put(addUserDTO.getUserId(), addUserDTO.getEndpoint());
            return true;
        } catch (Exception ex){
            return false;
        }
    }

    public List<String> getResourceByUserId(Long userId){
        return cache.get(userId);
    }

}
