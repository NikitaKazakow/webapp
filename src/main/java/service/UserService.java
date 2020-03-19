package service;

import dao.impl.UserDaoImpl;
import entity.UserEntity;

public class UserService {

    private static final UserDaoImpl userDao = new UserDaoImpl();

    public int registryNewUser(UserEntity newUser) {
        int result = 0;
        if (!userDao.get(newUser.getLoginUser()).isPresent())
            userDao.save(newUser);
        else
            result = 1;
        return result;
    }

    public boolean isUserExists(String userName, String password) {
        return userDao.isUserExist(userName, password);
    }
}
