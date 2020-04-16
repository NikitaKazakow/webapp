package entity;

import entity.pk.ComplectationEntityPK;
import lombok.*;

import javax.persistence.*;

@Setter
@Getter
@Entity
@ToString
@NoArgsConstructor
@EqualsAndHashCode
@IdClass(ComplectationEntityPK.class)
@Table(name = "complectation", schema = "public", catalog = "webapp")
public class ComplectationEntity {
    @Id
    @Column(name = "name_complectation", length = 30)
    private String nameComplectation;

    @Id
    @Column(name = "vin_number_car_fk", length = 17)
    String vinNumberCarFk;

    @Basic
    @Column(name = "price_complectation")
    private Integer priceComplectation;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "id_specification_fk")
    private SpecificationEntity specification;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vin_number_car_fk", referencedColumnName = "vin_number_car", nullable = false, insertable = false, updatable = false)
    private CarEntity car;
}
