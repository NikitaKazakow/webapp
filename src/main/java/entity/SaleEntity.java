package entity;

import entity.pk.SaleEntityPK;

import javax.persistence.*;
import java.math.BigInteger;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "sale", schema = "public", catalog = "webapp")
@IdClass(SaleEntityPK.class)
public class SaleEntity {
    private int idSale;
    private Date dateSale;
    private BigInteger paymentAmount;
    private String loginUserSaleFk;
    private ClientEntity client;
    private CarEntity carByVinNumberCarFk;
    private UserEntity userByLoginUserSaleFk;

    @Id
    @Column(name = "id_sale", nullable = false)
    public int getIdSale() {
        return idSale;
    }

    public void setIdSale(int idSale) {
        this.idSale = idSale;
    }

    @Basic
    @Column(name = "date_sale", nullable = false)
    public Date getDateSale() {
        return dateSale;
    }

    public void setDateSale(Date dateSale) {
        this.dateSale = dateSale;
    }

    @Basic
    @Column(name = "payment_amount", nullable = false)
    public BigInteger getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(BigInteger paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    @Id
    @Column(name = "login_user_sale_fk", nullable = false, length = 20)
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

        SaleEntity that = (SaleEntity) o;

        if (idSale != that.idSale) return false;
        if (!Objects.equals(dateSale, that.dateSale)) return false;
        if (!Objects.equals(paymentAmount, that.paymentAmount))
            return false;
        return Objects.equals(loginUserSaleFk, that.loginUserSaleFk);
    }

    @Override
    public int hashCode() {
        int result = idSale;
        result = 31 * result + (dateSale != null ? dateSale.hashCode() : 0);
        result = 31 * result + (paymentAmount != null ? paymentAmount.hashCode() : 0);
        result = 31 * result + (loginUserSaleFk != null ? loginUserSaleFk.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumns({@JoinColumn(name = "passport_series_client_fk", referencedColumnName = "passport_series_client", nullable = false), @JoinColumn(name = "passport_number_client_fk", referencedColumnName = "passport_number_client", nullable = false)})
    public ClientEntity getClient() {
        return client;
    }

    public void setClient(ClientEntity client) {
        this.client = client;
    }

    @ManyToOne
    @JoinColumn(name = "vin_number_car_fk", referencedColumnName = "vin_number_car", nullable = false)
    public CarEntity getCarByVinNumberCarFk() {
        return carByVinNumberCarFk;
    }

    public void setCarByVinNumberCarFk(CarEntity carByVinNumberCarFk) {
        this.carByVinNumberCarFk = carByVinNumberCarFk;
    }

    @ManyToOne
    @JoinColumn(name = "login_user_sale_fk", referencedColumnName = "login_user", nullable = false, insertable = false, updatable = false)
    public UserEntity getUserByLoginUserSaleFk() {
        return userByLoginUserSaleFk;
    }

    public void setUserByLoginUserSaleFk(UserEntity userByLoginUserSaleFk) {
        this.userByLoginUserSaleFk = userByLoginUserSaleFk;
    }
}
