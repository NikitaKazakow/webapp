package entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "user", schema = "public", catalog = "webapp")
public class UserEntity {
    private String loginUser;
    private String passwordUser;
    private Collection<SaleEntity> salesByLoginUser;

    @Id
    @Column(name = "login_user", nullable = false, length = 20)
    public String getLoginUser() {
        return loginUser;
    }

    public void setLoginUser(String loginUser) {
        this.loginUser = loginUser;
    }

    @Basic
    @Column(name = "password_user", nullable = false)
    public String getPasswordUser() {
        return passwordUser;
    }

    public void setPasswordUser(String passwordUser) {
        this.passwordUser = passwordUser;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserEntity that;
        that = (UserEntity) o;

        if (!Objects.equals(loginUser, that.loginUser)) return false;
        return Objects.equals(passwordUser, that.passwordUser);
    }

    @Override
    public int hashCode() {
        int result = loginUser != null ? loginUser.hashCode() : 0;
        result = 31 * result + (passwordUser != null ? passwordUser.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "userByLoginUserSaleFk")
    public Collection<SaleEntity> getSalesByLoginUser() {
        return salesByLoginUser;
    }

    public void setSalesByLoginUser(Collection<SaleEntity> salesByLoginUser) {
        this.salesByLoginUser = salesByLoginUser;
    }
}
