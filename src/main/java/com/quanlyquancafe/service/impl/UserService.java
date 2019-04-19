package com.quanlyquancafe.service.impl;

import com.quanlyquancafe.dao.IUserDAO;
import com.quanlyquancafe.dao.impl.UserDAO;
import com.quanlyquancafe.model.UserModel;
import com.quanlyquancafe.service.IUserService;

import java.sql.Timestamp;
import java.util.List;

public class UserService implements IUserService {

    private IUserDAO userDAO;

    public UserService() {
        userDAO = new UserDAO();
    }

    @Override
    public UserModel findByUserNameAndPasswordAndStatus(String userName, String password, Integer status) {
        return userDAO.findByUserNameAndPasswordAndStatus(userName, password, status);
    }

    @Override
    public Long save(UserModel userModel) {
        userModel.setStatus(1);
        userModel.setRoleId((long) 3);
        Long userID=userDAO.save(userModel);
        return userID;
    }

    @Override
    public UserModel findOne(long id) {
       UserModel model=userDAO.findOne(id);
       return model;
    }

    @Override
    public List<UserModel> listAll() {
        return userDAO.listAll();
    }

    @Override
    public Long saveInforUser(UserModel userModel) {
        userModel.setStatus(1);
        Long userID=userDAO.saveInforUser(userModel);
        return userID;
    }

    @Override
    public boolean update(UserModel userModelUpdate) {
        userModelUpdate.setModifiedDate(new Timestamp(System.currentTimeMillis()));
        userModelUpdate.setModifiedBy(userModelUpdate.getUserName());
        return userDAO.update(userModelUpdate);
    }

    @Override
    public void delete(long[] ids) {
        for (long id : ids) {
            userDAO.delete(id);
        }
    }
}