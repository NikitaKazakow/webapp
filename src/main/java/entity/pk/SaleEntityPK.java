package entity.pk;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class SaleEntityPK implements Serializable {
    private int idSale;
    private String loginUserSaleFk;

    @Column(name = "id_sale", nullable = false)
    @Id
    public int getIdSale() {
        return idSale;
    }

    public void setIdSale(int idSale) {
        this.idSale = idSale;
    }

    @Column(name = "login_user_sale_fk", nullable = false, length = 20)
    @Id
    public String getLoginUserSaleFk() {
        return loginUserSaleFk;
    }

    public void setLoginUserSaleFk(String loginUserSaleFk) {
        this.loginUserSaleFk = loginUserSaleFk;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SaleEntityPK that = (SaleEntityPK) o;

        if (idSale != that.idSale) return false;
        if (loginUserSaleFk != null ? !loginUserSaleFk.equals(that.loginUserSaleFk) : that.loginUserSaleFk != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idSale;
        result = 31 * result + (loginUserSaleFk != null ? loginUserSaleFk.hashCode() : 0);
        return result;
    }
}
