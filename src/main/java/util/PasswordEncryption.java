package util;

import org.mindrot.jbcrypt.BCrypt;

public class PasswordEncryption {

    public static String crypt(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

    public static boolean checkPasswords(String password, String passwordHash) {
        return BCrypt.checkpw(password, passwordHash);
    }
}
