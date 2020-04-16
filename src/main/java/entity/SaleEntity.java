package entity;

import entity.pk.SaleEntityPK;
import lombok.*;

import javax.persistence.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

@Getter
@Entity
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@IdClass(SaleEntityPK.class)
@Table(name = "sale", schema = "public", catalog = "webapp")
public class SaleEntity {
    @Id
    @Setter
    @Column(name = "login_user_fk", length = 20)
    private String loginUserSaleFk;

    @Id
    @Setter
    @Column(name = "vin_number_car_fk", length = 17)
    private String vinNumberCarFk;

    @Id
    @Setter
    @Column(name = "client_passport_number_fk", length = 17)
    private String passportNumberClientFk;

    @Basic
    @Column(name = "date_sale")
    private Calendar dateSale;

    @Basic
    @Setter
    @Column(name = "payment_amount")
    private Integer paymentAmount;

    @Setter
    @OneToOne
    @JoinColumn(name = "client_passport_number_fk", referencedColumnName = "passport_number_client", insertable = false, updatable = false)
    private ClientEntity client;

    @Setter
    @OneToOne
    @JoinColumn(name = "vin_number_car_fk", referencedColumnName = "vin_number_car", insertable = false, updatable = false)
    private CarEntity carByVinNumberCarFk;

    @Setter
    @ManyToOne
    @JoinColumn(name = "login_user_fk", referencedColumnName = "login_user", insertable = false, updatable = false)
    private UserEntity user;

    public void setDateSale() {
        this.dateSale = Calendar.getInstance();
    }

    public void setDateSale(Calendar dateSale) {
        this.dateSale = dateSale;
    }

    public String getData(){
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(dateSale.getTime());
    }
}
