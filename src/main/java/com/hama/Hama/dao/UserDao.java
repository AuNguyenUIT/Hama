package com.hama.Hama.dao;

import com.hama.Hama.model.User;

import java.util.List;

public interface UserDao {
    void insert(User user);

    void edit(User user);

    void delete(String id);

    User get(int id);

    User get(String email);

    List<User> getAll();

}
