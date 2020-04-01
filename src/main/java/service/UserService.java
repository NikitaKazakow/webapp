package service;

import dao.impl.UserDaoImpl;
import entity.UserEntity;
import util.PasswordEncryption;

import java.util.Optional;

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

    public boolean isUserExists(String userName) {
        boolean result = false;
        Optional<UserEntity> optionalUserEntity = userDao.get(userName);
        if (optionalUserEntity.isPresent()) {
            result = true;
        }
        return result;
    }

    public boolean checkPassword(String login, String password) {
        Optional<UserEntity> userEntity = userDao.get(login);
        if (userEntity.isPresent()) {
            String passwordHash = userEntity.get().getPasswordUser();
            return PasswordEncryption.checkPasswords(password, passwordHash);
        }
        else
            return false;
    }
}
