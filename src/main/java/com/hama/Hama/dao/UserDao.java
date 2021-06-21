package com.hama.Hama.dao;

import com.hama.Hama.entities.UserEntity;

import java.util.List;

public interface UserDao {
    List<UserEntity> getUsers();

    int saveUser(UserEntity user);

    void deleteUser(int id);

    UserEntity getUser(int id);

    UserEntity getUserByUserNameAndPassword(String username, String password);
}
