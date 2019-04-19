package com.quanlyquancafe.dao;

import com.quanlyquancafe.model.UserModel;

import java.util.List;

public interface IUserDAO extends GenericDAO<UserModel> {
    UserModel findByUserNameAndPasswordAndStatus(String userName, String password, Integer status);
    Long save(UserModel userModel);
    UserModel findOne(Long id);
    boolean validate(UserModel userModel);
    List<UserModel> listAll();

    Long saveInforUser(UserModel userModel);

    boolean update(UserModel userModelUpdate);

    void delete(Long id);
}
