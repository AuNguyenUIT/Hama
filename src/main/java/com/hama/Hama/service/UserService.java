package com.hama.Hama.service;

import com.hama.Hama.entities.UserEntity;

import java.util.List;

public interface UserService {

    Integer saveUser(UserEntity user);

    void deleteUser(Integer id);

    List<UserEntity> getUsers();

    UserEntity getUser(Integer id);

    UserEntity getUserByUserNameAndPassword(String username, String password);
}
