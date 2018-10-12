package com.wei.cityinfo.service;

import com.wei.cityinfo.dao.UserDao;
import com.wei.cityinfo.model.User;

public class UserService {
    private UserDao dao = new UserDao();
    public boolean login(User user) {
        return dao.find(user);
    }
}
