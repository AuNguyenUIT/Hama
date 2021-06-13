package com.hama.Hama.service.Impl;

import com.hama.Hama.dao.UserDao;
import com.hama.Hama.entities.UserEntity;
import com.hama.Hama.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserServicesImpl implements UserService {
    @Autowired
    UserDao userDao;

    @Override
    @Transactional
    public Integer saveUser(UserEntity user) {
        return userDao.saveUser(user);
    }

    @Override
    @Transactional
    public void deleteUser(Integer id) {
        userDao.deleteUser(id);
    }

    @Override
    @Transactional
    public List<UserEntity> getUsers() {
        return userDao.getUsers();
    }

    @Override
    @Transactional
    public UserEntity getUser(Integer id) {
        return userDao.getUser(id);
    }

    @Override
    @Transactional
    public UserEntity getUserByUserNameAndPassword(String username, String password) {
        return userDao.getUserByUserNameAndPassword(username, password);
    }
}
