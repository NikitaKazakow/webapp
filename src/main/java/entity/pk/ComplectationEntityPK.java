package entity.pk;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
public class ComplectationEntityPK implements Serializable {
    @Id
    @Column(name = "name_complectation", nullable = false, length = 30)
    private String nameComplectation;

    @Id
    @Column(name = "vin_number_car_fk", nullable = false, length = 17)
    String vinNumberCarFk;
}
