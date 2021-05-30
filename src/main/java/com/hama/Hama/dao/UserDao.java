package com.hama.Hama.dao;

import com.hama.Hama.entities.UserEntity;

import java.util.List;

public interface UserDao {
    void insert(UserEntity user);

    void edit(UserEntity user);

    void delete(String id);

    UserEntity get(int id);

    UserEntity get(String email);

    List<UserEntity> getAll();

}
