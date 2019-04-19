package com.quanlyquancafe.service;

import com.quanlyquancafe.model.UserModel;

import java.util.List;

public interface IUserService {
    UserModel findByUserNameAndPasswordAndStatus(String userName, String password, Integer status);

    Long save( UserModel userModel);

    UserModel findOne(long id);

    List<UserModel> listAll();

    Long saveInforUser( UserModel userModel);

    void delete(long[] ids);

    boolean update(UserModel userModelUpdate);
}
