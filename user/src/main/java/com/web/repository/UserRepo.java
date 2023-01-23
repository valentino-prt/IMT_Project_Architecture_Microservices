package com.web.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.web.model.UserTransaction;

import java.util.List;

@Repository
public class UserRepo {
    public static final String HASH_KEY_NAME = "MENU-ITEM";
    @Autowired
    private RedisTemplate redisTemplate;


    public UserTransaction save(UserTransaction userModel){
        redisTemplate.opsForHash().put(HASH_KEY_NAME,userModel.getId(),userModel);
        return userModel;
    }

    public List<UserTransaction> findAll(){
        return redisTemplate.opsForHash().values(HASH_KEY_NAME);
    }

    public UserTransaction findItemById(int id){
        return (UserTransaction) redisTemplate.opsForHash().get(HASH_KEY_NAME,id);
    }


    public String deleteUserModel(int id){
        redisTemplate.opsForHash().delete(HASH_KEY_NAME,id);
        return "UserModel deleted successfully !!";
    }
}