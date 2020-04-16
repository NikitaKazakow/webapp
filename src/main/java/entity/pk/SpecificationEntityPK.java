package entity.pk;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

@Getter
@Setter
@ToString
@NoArgsConstructor
@EqualsAndHashCode
public class SpecificationEntityPK implements Serializable {

    @Id
    @Column(name = "name_complectation_specification_fk", nullable = false, length = 30)
    private String nameComplectationSpecificationFk;

    @Id
    @Column(name = "vin_number_car_specification_fk", nullable = false, length = 17)
    private String vinNumberCarSpecificationFk;
}
