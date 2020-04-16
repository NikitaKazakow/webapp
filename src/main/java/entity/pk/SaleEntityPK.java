package entity.pk;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class SaleEntityPK implements Serializable {
    @Id
    @Column(name = "login_user_fk", nullable = false, length = 20)
    private String loginUserSaleFk;

    @Id
    @Column(name = "vin_number_car_fk", nullable = false, length = 17)
    private String vinNumberCarFk;

    @Id
    @Column(name = "client_passport_number_fk", nullable = false, length = 17)
    private String passportNumberClientFk;
}
